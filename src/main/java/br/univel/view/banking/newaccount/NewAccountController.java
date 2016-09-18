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

	}

	boolean isValid() {
		String errorMessage;
		if ((this.agency != null) && (this.name != null) && (this.typeAccount != null) && (this.username != null)
				&& (this.passwordAccess != null) && (this.passwordOperation != null) && (this.cpf != null)
				&& (this.age != null)) {
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
