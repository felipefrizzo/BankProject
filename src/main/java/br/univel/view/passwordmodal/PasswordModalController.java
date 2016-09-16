package br.univel.view.passwordmodal;

import br.univel.model.person.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * Created by felipefrizzo on 9/15/16.
 */
public class PasswordModalController {
    private Stage dialogStage;
    private Person person;
    private boolean OkPassword = false;

    @FXML
    private PasswordField password;

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkPassword() {
        return OkPassword;
    }

    @FXML
    public void initialize() {
    }

    @FXML
    void handleCancel(ActionEvent event) {
        dialogStage.close();
    }

    @FXML
    void handleClean(ActionEvent event) {
        password.setText("");
    }

    @FXML
    void handleConfirm(ActionEvent event) {
        if (isInputValid()) {
            if (person.getOperationPassword().equals(password.getText())) {
                OkPassword = true;
                dialogStage.close();
            } else {
                showError("Senha inválida", "Por favor, corrija os campos inválidos", "Senha inválida");
                password.setText("");
            }
        } else {
            showError("Senha em branco", "Por favor, corrija os campos inválidos", "Senha em branco, digite sua senha");
        }
    }

    @FXML
    void handleDigitPassword(ActionEvent event) {
        Button button = (Button) event.getSource();
        password.setText(password.getText() + button.getText());
    }

    public boolean isInputValid() {
        if (password.getText() == null || password.getLength() == 0 ){
            return false;
        } else {
            return true;
        }
    }

    public void showError(String title, String headerTitle, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(dialogStage);
        alert.setTitle(title);
        alert.setHeaderText(headerTitle);
        alert.setContentText(contentText);

        alert.showAndWait();
    }
}
