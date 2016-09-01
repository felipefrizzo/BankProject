package br.univel.view.login;

import br.univel.Main;
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
    	if (isInputValid()){
    		
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
