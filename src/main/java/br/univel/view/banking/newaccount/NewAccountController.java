package br.univel.view.banking.newaccount;

import br.univel.database.account.AccountService;
import br.univel.database.agency.AgencyService;
import br.univel.database.person.PersonService;
import br.univel.model.agency.Agency;
import br.univel.model.person.Person;
import br.univel.model.person.TypePerson;
import br.univel.model.person.TypePersonFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NewAccountController {
    final private PersonService personService = new PersonService();
    final private AccountService accountService = new AccountService();
    final private AgencyService agencyService = new AgencyService();
    
    private Agency agency;
    
	@FXML
	private TextField tFAgency;

	@FXML
	private PasswordField passwordAccess;

	@FXML
	private TextField cpf;

	@FXML
	private TextField age;

	@FXML
	private PasswordField passwordOperation;

	@FXML
	private TextField name;

	@FXML
	private ComboBox<?> typeAccount;

	@FXML
	private TextField username;

	@FXML
	void handleNewAccount(ActionEvent event) {
		String errorMessage;
		if(isInputValid()){ 
			agency = agencyService.
			
			
	        Person person = new TypePersonFactory().create(
	        	TypePerson.CUSTOMER, 
	        	this.name.getText(), 
	        	this.username.getText(),
	        	Integer.parseInt(this.age.getText()),
	        	this.cpf.getText(), 
	        	this.passwordAccess.getText(), 
	        	this.passwordOperation.getText()
	        );

	        personService.save(person);
		}
	}

	protected boolean isInputValid() {
		String errorMessage = "";
		if (this.passwordOperation.getLength() > 6) {
			showError(
				"TITULO",
				"A senha deve conter 6 digitos",
				"A senha deve conter 6 digitos"
			); 
			return false;
		}
		
		if (this.tFAgency.getText() == null || this.tFAgency.getLength() == 0) {
			errorMessage += "A Agencia não pode estar em branco";
		}
		
		
		
		if (errorMessage.equals("")) {
			showError(
				"TITULO",
				"HUEIHFE",	
				errorMessage
			);
			return false;
		} else {
			return true;
		}
		
//		if ((this.agency.getText() != null) && (this.name.getText() == null) && (this.typeAccount == null)
//				&& (this.username.getText() == null) && (this.passwordAccess.getText() == null)
//				&& (this.passwordOperation.getText() == null) && (this.cpf.getText() == null)
//				&& (this.age.getText() == null)) {
//			int lenghtPassword = this.passwordOperation.getLength();
//			if (lenghtPassword == 6) {
//				return true;
//			} else {
//				errorMessage = "Senha de Operação inválida! Deve conter 6 digitos\n";
//				return false;
//			}
//
//		} else {
//			errorMessage = "Todos os campos devem ser Completados";
//			return false;
//		}
	}
	
	protected void showError(String s, String n, String k) {
		Alert alert = new Alert();
	}

}
