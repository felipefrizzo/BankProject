package br.univel.view.banking.newaccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NewAccountController {

	@FXML
	private Button confirm;

	@FXML
	private TextField agency;

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
	void handle(ActionEvent event) {
		isValid();
	}

	boolean isValid() {
		String errorMessage;
		if ((this.agency.getText() == null) && (this.name.getText() == null) && (this.typeAccount == null)
				&& (this.username.getText() == null) && (this.passwordAccess.getText() == null)
				&& (this.passwordOperation.getText() == null) && (this.cpf.getText() == null)
				&& (this.age.getText() == null)) {
			int lenghtPassword = this.passwordOperation.getLength();
			if (lenghtPassword == 6) {
				return true;
			} else {
				errorMessage = "Senha de Operação inválida! Deve conter 6 digitos";
				return false;
			}

		} else {
			errorMessage = "Todos os campos devem ser Completados";
			return false;
		}
	}

}
