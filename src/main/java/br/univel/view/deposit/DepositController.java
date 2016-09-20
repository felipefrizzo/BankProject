package br.univel.view.deposit;

import br.univel.Main;
import br.univel.database.account.AccountService;
import br.univel.model.account.Account;
import br.univel.model.account.TypeAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.math.BigDecimal;

/**
 * Created by felipefrizzo on 9/12/16.
 */
public class DepositController {
    private Main main;
    private Account account;
    private AccountService accountService = new AccountService();

    @FXML
    private void initialize() {
        typeAccount.getItems().setAll(TypeAccount.CURRENT, TypeAccount.ELETRONIC, TypeAccount.SAVINGS);
    }

    @FXML
    private CheckBox isLogged;

    @FXML
    private TextField agency;

    @FXML
    private TextField tfValue;

    @FXML
    private TextField numberAccount;

    @FXML
    private ComboBox<TypeAccount> typeAccount;

    @FXML
    private TextField holder;

    public void setMain(Main main) {
        this.main = main;
        this.account = main.getAccount();
        showInformation(true);
    }

    @FXML
    void handleConfirmDeposit(ActionEvent event) {
        if (isInputValid(true)) {
            String value = tfValue.getText().replace(",", ".");
            BigDecimal newValue = new BigDecimal(value);

            newValue = newValue.add(account.getBalance());

            account.setBalance(newValue);
            accountService.update(account);
        }
    }

    @FXML
    void handleBack(ActionEvent event) {
        main.showMainCustomerLayout();
    }

    @FXML
    void handleChangeAccount(KeyEvent event) {
        if (isInputValid(false)) {
            if (!agency.getText().equals(account.getAgency().getNumero())
                    || !numberAccount.getText().equals(String.valueOf(account.getAccountNumber()))) {

                account = accountService.getAccountByNumberAccountTypeAccountAgency(
                    numberAccount.getText(),
                    typeAccount.getSelectionModel().getSelectedItem(),
                    agency.getText()
                );
            }
            showInformation(false);
        }
    }

    @FXML
    void onClickChangeAccount(MouseEvent event) {
        if (isInputValid(false)) {
            if (!agency.getText().equals(account.getAgency().getNumero())
                    || !numberAccount.getText().equals(String.valueOf(account.getAccountNumber()))) {

                account = accountService.getAccountByNumberAccountTypeAccountAgency(
                        numberAccount.getText(),
                        typeAccount.getSelectionModel().getSelectedItem(),
                        agency.getText()
                );
            }
            showInformation(false);
        }
    }

    @FXML
    void handleLogged(ActionEvent event) {
        if (this.isLogged.isSelected()) {
            this.agency.setDisable(true);
            this.numberAccount.setDisable(true);
            this.typeAccount.setDisable(true);
            showInformation(true);
        } else {
            this.agency.setDisable(false);
            this.numberAccount.setDisable(false);
            this.typeAccount.setDisable(false);
            cleanFields();
        }
    }

    public void showInformation(boolean getMainAccount) {
        if (getMainAccount) {
            this.account = this.main.getAccount();
        }

        agency.setText(account.getAgency().getNumero());
        numberAccount.setText(String.valueOf(account.getAccountNumber()));
        holder.setText(account.getClient().getName());
        typeAccount.getSelectionModel().select(account.getTypeAccount()); 	
    }

    public void cleanFields() {
        agency.setText("");
        numberAccount.setText("");
        holder.setText("");
        typeAccount.getSelectionModel().clearSelection();
    }

    public boolean isInputValid(boolean isConfirmed) {
        String errorMessage = "";
        if (agency.getText() == null || agency.getLength() == 0) {
            errorMessage += "Agencia não pode estar em branco\n";
        }
        if (numberAccount.getText() == null || numberAccount.getLength() == 0) {
            errorMessage += "Numero da conta não pode estar em branco\n";
        }
        if (typeAccount.getSelectionModel().isEmpty()) {
            errorMessage += "Tipo da conta não pode estar em branco\n";
        }
        if (tfValue.getText() == null | tfValue.getLength() == 0) {
            errorMessage += "O valor a ser depositado não pode estar em branco\n";
        }

        if (errorMessage.equals("")) {
            return true;
        } else {
            if (isConfirmed) {
                showError(
                    "Campo inválido",
                    "Por favor, corrija o campo inválido",
                    errorMessage
                );
            } else {
            	holder.setText("");
            }
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
