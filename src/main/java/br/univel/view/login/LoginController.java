package br.univel.view.login;

import br.univel.Main;
import br.univel.cryptography.person.CryptographyFactory;
import br.univel.database.account.AccountService;
import br.univel.database.person.PersonService;
import br.univel.model.account.Account;
import br.univel.model.person.Person;
import br.univel.model.person.TypePerson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

/**
 * Created by lfsobrinho on 8/30/16.
 */
public class LoginController {
	private AccountService accountService = new AccountService();
	private PersonService personService = new PersonService();

	private Main main;
	@FXML
	private PasswordField password;

	@FXML
	private Button login;

	@FXML
	private TextField username;

	@FXML
	private Label errorMsg;

	public void setMainApp(Main main) {
		this.main = main;
	}

	@FXML
	private void handleLogin() {
		String newPassword = null;

		CryptographyFactory crypto = new CryptographyFactory();
		List<Person> person;

		if (isInputValid()) {
			person = personService.getAll("FROM Customer");
			
			for (Person p : person) {
				if (p.getUsername().equalsIgnoreCase(this.username.getText())) {
					if (p.getTypePerson() == TypePerson.CUSTOMER) {
						String pwd = this.username.getText() + this.password.getText();
						newPassword = crypto.create(pwd, p.getTypePerson());
					} else if (p.getTypePerson() == TypePerson.BANKING) {
						newPassword = crypto.create(this.password.getText(), p.getTypePerson());
					}
				}
			}

			for (Person p : person) {
				if (p.getAccessPassword().equals(newPassword) && p.getUsername().equals(this.username.getText())) {
					if (p.getTypePerson() == TypePerson.CUSTOMER) {
						Account account = accountService.getAccountByCustomer(p);

						if (!account.isActive()) {
							main.showMainCustomerLayout();
							main.setAccount(account);
							main.setBanking(false);
						} else {
							this.errorMsg.setText("Conta inátiva");
							this.errorMsg.setVisible(true);
						}
					} else if (p.getTypePerson() == TypePerson.BANKING) {
						main.showMainBankingLayout();
						main.setBanking(true);
						main.setBanking(p);
					}

				} else {
					this.errorMsg.setText("Usuário ou senha incorretas");
					this.errorMsg.setVisible(true);
				}
			}
		}
	}

	private boolean isInputValid() {
		String errorMessage = "";
		if ((this.username.getText() == null || this.username.getLength() == 0)
				&& (this.password.getText() == null || this.password.getLength() == 0)) {
			errorMessage = "Informe usuário e senha.";
		} else {
			if (this.username.getText() == null || this.username.getLength() == 0) {
				errorMessage = "Informe o usuário.";
			}
			if (this.password.getText() == null || this.password.getLength() == 0) {
				errorMessage = "Informe a senha.";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			this.errorMsg.setVisible(true);
			this.errorMsg.setText(errorMessage);
			return false;
		}
	}
}
