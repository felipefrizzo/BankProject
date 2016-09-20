package br.univel.view.cashwithdrawl;

import br.univel.Main;
import br.univel.database.account.AccountService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

/**
 * Created by felipefrizzo on 9/12/16.
 */
public class CashWithdrawalController {
    private AccountService accountService = new AccountService();
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private TextField withdrawalValue;

    @FXML
    void handleConfirmWithdrawal(ActionEvent event) {
        if (withdrawalValue.getText() == null || withdrawalValue.getLength() == 0) {
            showError(
                    "Campo inválido",
                    "Por favor, corrija o campo inválido",
                    "O campo valor não pode estar em branco"
            );
        } else {
            String value = withdrawalValue.getText().replace(",", ".");
    	    BigDecimal withdral = new BigDecimal(value);

            if (isValidBalance(withdral)) {
                boolean okPassword = main.showPasswordModal(main.getAccount().getClient());
                if (okPassword) {
                    updateBalance(withdral);
                }
            } else {
                showError(
                        "Saldo insulficiente",
                        "Saldo insulficiente",
                        "Você não tem saldo sulficiente para completar essa transação"
                );
            }
        }
    }

    @FXML
    void handleWithdrawal(ActionEvent event) {
        Button button = (Button) event.getSource();
        BigDecimal withdrawal = new BigDecimal(button.getAccessibleText());

        if (isValidBalance(withdrawal)) {
            boolean okPassword = main.showPasswordModal(main.getAccount().getClient());
            if (okPassword) {
                updateBalance(withdrawal);
            }
        } else {
            showError(
                    "Saldo insulficiente",
                    "Saldo insulficiente",
                    "Você não tem saldo sulficiente para completar essa transação"
            );
        }
    }

    @FXML
    void handleBack(ActionEvent event) {
        main.showMainCustomerLayout();
    }

    protected Boolean isValidBalance(BigDecimal withdrawal) {
        return !(this.main.getAccount().getBalance().compareTo(withdrawal) == -1);
    }

    protected void updateBalance(BigDecimal withdrawal) {
        BigDecimal newbalance = this.main.getAccount().getBalance().subtract(withdrawal);
        main.getAccount().setBalance(newbalance);
        accountService.update(main.getAccount());
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
