package br.univel.view.login;

import java.util.List;

import br.univel.Main;
import br.univel.cryptography.person.CryptographyCustomer;
import br.univel.cryptography.person.CryptographyFactory;
import br.univel.database.person.PersonService;
import br.univel.model.person.AbstractPerson;
import br.univel.model.person.Customer;
import br.univel.model.person.Person;
import br.univel.model.person.PersonFactory;
import br.univel.model.person.TypePerson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by lfsobrinho on 8/30/16.
 */
public class LoginController {
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
    void initialize() {
    	
    }
    
    @FXML
    private void handleLogin(String user , String password){
    	
    	String newPass = null;
    	
    	List <Person> person = null;
    	PersonService service = new PersonService();
    	person = service.getAll("FROM PERSON");
    	
    	if (isInputValid()){
    		for (Person person1 : person ) {
				if(user.equalsIgnoreCase(person1.getUsername())){
					if (person1.getTypePerson() == TypePerson.CUSTOMER) {
						String pwd = username + password;
						newPass = new CryptographyFactory.create(pwd, person1.getTypePerson());
					}else{
						//newPass = new CryptographyFactory.create(password, );
					}
				}
			}
    		
    		for (Person person2 : person) {
				if(user.equalsIgnoreCase(person2.getUsername()) && newPass.equalsIgnoreCase(person2.getOperationPassword())){
					if(person2.getTypePerson() == TypePerson.CUSTOMER){
						return new PersonFactory().	
				}
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
    	
		if (errorMessage.length() == 0){
			return true;
		}else{
			this.errorMsg.setVisible(true);
			this.errorMsg.setText(errorMessage);
			return false;
		}
    }
}
