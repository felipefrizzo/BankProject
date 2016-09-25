package br.univel.view.banking.professionalslist;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import br.univel.Main;
import br.univel.database.person.PersonService;
import br.univel.model.account.Account;
import br.univel.model.person.Customer;
import br.univel.model.person.Person;
import br.univel.model.person.PersonFactory;
import br.univel.model.person.TypePerson;
import br.univel.model.person.TypePersonFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ProfessionalsFormController {

	private Main main;
	private PersonService personService = new PersonService();
	
	
	@FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private TextField cpf;

    @FXML
    private TextField username;

    @FXML
    private PasswordField passwordAccess;

    @FXML
    private PasswordField passwordOperation;

    @FXML
    private Button confirm;

    @FXML
    void handleBack(ActionEvent event) {
    	main.showMainBankingLayout();
    }

    @FXML
    void handleNewBanking(ActionEvent event) {
    	if (isInputValid()) {

			Person person = new TypePersonFactory().create(
				TypePerson.BANKING, 
				this.name.getText(),
				this.username.getText(), 
				Integer.parseInt(this.age.getText()), 
				this.cpf.getText(),
				this.passwordAccess.getText(), 
				this.passwordOperation.getText()
			);
				personService.save(person);	
				cleanFields();
			
		}
	}

    protected void cleanFields() {
		passwordAccess.setText("");
		cpf.setText("");
		age.setText("");
		passwordOperation.setText("");
		name.setText("");
		username.setText("");
	}

    private boolean isInputValid(){
    	String errorMessage = "";
		if (this.passwordOperation.getLength() < 6) {
			showError(
					"Senha Inválida",
					"A senha deve conter 6 digitos",
					"A senha deve conter 6 digitos"
			);
			return false;
		}

		if (this.name.getText() == null || this.name.getLength() == 0) {
			errorMessage += "O nome não pode estar em branco\n";
		}

		if (this.cpf.getText() == null || this.cpf.getLength() == 0) {
			errorMessage += "O cpf não pode estar em branco\n";
		}

		if (this.age.getText() == null || this.age.getLength() == 0) {
			errorMessage += "A idade não pode estar em branco\n";
		}

		if (this.username.getText() == null || this.username.getLength() == 0) {
			errorMessage += "O usuáio não pode estar em branco\n";
		}

		if (this.passwordAccess.getText() == null || this.passwordAccess.getLength() == 0) {
			errorMessage += "A senha de Acesso não pode estar em branco\n";
		}

		if (this.passwordOperation.getText() == null || this.passwordOperation.getLength() == 0) {
			errorMessage += "A senha de Operação não pode estar em branco\n";
		}

		
		if (errorMessage.equals("")) {
			return true;
		} else {
			showError("Erros",
					"Por favor corrija os campos Inválidos",
					errorMessage
			);
			return false;
		}
    }
    
	protected void showError(String title, String headerTitle, String contentText) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.initOwner(main.getPrimaryStage());
		alert.setTitle(title);
		alert.setHeaderText(headerTitle);
		alert.setContentText(contentText);

		alert.showAndWait();
	}

}

