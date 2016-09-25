package br.univel.view.banking.popoutaccount;

import br.univel.model.account.TypeAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PopOutController {

	@FXML
	private Button confirm;

	@FXML
	private TextField agency;

	@FXML
	private ComboBox<TypeAccount> typeAccount;

	@FXML
	private TextField holder;

	@FXML
	private TextField account;
	
	@FXML
	private void handleConfirm(){
		
	}

}
