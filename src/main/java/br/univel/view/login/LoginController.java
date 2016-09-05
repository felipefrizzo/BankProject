package br.univel.view.login;

import java.util.List;

import org.bouncycastle.crypto.RuntimeCryptoException;

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
    private void handleLogin(){
    	String errorMessage;
    	String newPassword = null;
 
    	CryptographyFactory crypto = new CryptographyFactory();
    	List <Person> person = null;
    	PersonService service = new PersonService();
    	person = service.getAll("FROM PERSON");
    	
    	if (isInputValid()){
    		for (Person p : person ) {
				if(p.getUsername().equalsIgnoreCase(this.username.getText())){
					if (p.getTypePerson() == TypePerson.CUSTOMER) {
						String pwd = this.username.getText() + this.password.getText();
						newPassword = crypto.create(pwd, p.getTypePerson());
					} else if (p.getTypePerson() == TypePerson.BANKING){
						newPassword = crypto.create(this.password.getText(), p.getTypePerson());
					}
				}
			}
    		
    		for (Person p : person) {
				if(this.username.getText().equalsIgnoreCase(p.getUsername()) && newPassword.equalsIgnoreCase(p.getOperationPassword())){
					if(p.getTypePerson() == TypePerson.CUSTOMER){
						return new PersonFactory();
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
