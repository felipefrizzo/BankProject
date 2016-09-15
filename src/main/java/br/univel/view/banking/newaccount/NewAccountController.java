package br.univel.view.banking.newaccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NewAccountController {

	@FXML
	private TextField agency;

	@FXML
	private PasswordField passwordAccess;

	@FXML
	private PasswordField passwordOperation;

	@FXML
	private TextField name;

	@FXML
	private ComboBox<?> typeAccount;

	@FXML
	private TextField username;

	@FXML
	void handle(ActionEvent event) {

	}

}
