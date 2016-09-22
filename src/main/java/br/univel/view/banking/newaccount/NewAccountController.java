package br.univel.view.banking.newaccount;

import br.univel.Main;
import br.univel.database.account.AccountService;
import br.univel.database.agency.AgencyService;
import br.univel.database.person.PersonService;
import br.univel.model.account.AccountFactory;
import br.univel.model.account.TypeAccount;
import br.univel.model.agency.Agency;
import br.univel.model.person.Person;
import br.univel.model.person.TypePerson;
import br.univel.model.person.TypePersonFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NewAccountController {
    final private PersonService personService = new PersonService();
    final private AccountService accountService = new AccountService();
    final private AgencyService agencyService = new AgencyService();
    final private AccountFactory accountFactory = new AccountFactory();
    final private GenerateAccountNumber generateAccount = new GenerateAccountNumber(null);
    
    private Agency agency;
    private Main main;
    
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
	private ComboBox<TypeAccount> typeAccount;

	@FXML
	private TextField username;

	public void setMain (Main main){
		this.main = main;
	}
	
	@FXML
	void handleNewAccount(ActionEvent event) {
		if(isInputValid()){ 
			agency = agencyService.getByNumberAgency(this.tFAgency.getText());
			Long numberAccount;
			
	        Person person = new TypePersonFactory().create(
	        	TypePerson.CUSTOMER, 
	        	this.name.getText(), 
	        	this.username.getText(),
	        	Integer.parseInt(this.age.getText()),
	        	this.cpf.getText(), 
	        	this.passwordAccess.getText(), 
	        	this.passwordOperation.getText()
	        );
	        
	        if (personService.getByCPF(this.cpf.getText()) == null) {
	        	personService.save(person);
			}else{
				showError(
						"Usuário ja Cadastrado",
						"Pessoa ja conta no nosso registro",	
						"Ja existe uma pessoa com essse mesmo cpf"
					);
			}
	        
	        
	        accountFactory.create(this.typeAccount.getSelectionModel().getSelectedItem(),numberAccount, person, agency, 00);
		}
	}	
		

	protected boolean isInputValid() {
		String errorMessage = "";
		if (this.passwordOperation.getLength() > 6) {
			showError(
				"Senha Inválida",
				"A senha deve conter 6 digitos",
				"A senha deve conter 6 digitos"
			); 
			return false;
		}
		
		if (this.tFAgency.getText() == null || this.tFAgency.getLength() == 0) {
			errorMessage += "A Agencia não pode estar em branco\n";
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
		
		if (this.typeAccount.getSelectionModel().getSelectedItem() == null ){
			errorMessage += "Selecione o tipo da conta";
		}
		
		if (errorMessage.equals("")) {
			return true;
		} else {
			showError(
					"Erros",
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
