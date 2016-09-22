package br.univel.view.payment;

import br.univel.Main;
import br.univel.database.account.AccountService;
import br.univel.database.operationbanking.OperationBankingService;
import br.univel.model.operationbanking.OperationBanking;
import br.univel.model.operationbanking.OperationBankingFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by felipefrizzo on 9/13/16.
 */
public class PaymentController {
    final private AccountService accountService = new AccountService();
    final private OperationBankingService operationBankingService = new OperationBankingService();
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private TextField barCode;

    @FXML
    private TextField valuePayment;

    @FXML
    void handlePaymentConfirm(ActionEvent event) {
        if (isInputValid()) {
            String value = valuePayment.getText().replace(",", ".");
            BigDecimal payment = new BigDecimal(value);

            if (main.showPasswordModal(main.getAccount().getClient())) {
                BigDecimal newbalance = this.main.getAccount().getBalance().subtract(payment);
                main.getAccount().setBalance(newbalance);
                accountService.update(main.getAccount());

                OperationBanking operationBanking = new OperationBankingFactory()
                        .create(main.getAccount(), "Pagamento", payment, new Date());
                operationBankingService.save(operationBanking);
            }
        }
    }

    @FXML
    void handleBack(ActionEvent event) {
        main.showMainCustomerLayout();
    }


    protected boolean isInputValid() {
        String errorMessage = "";
        if (barCode.getText() == null || barCode.getLength() == 0) {
            errorMessage = "Por favor digite o código de barras\n";
        }
        if (valuePayment.getText() == null || valuePayment.getLength() == 0) {
            errorMessage = "Por favor digite o valor do boleto\n";
        }
        if (errorMessage.equals("")) {
            return true;
        } else {
            showError(
                "Campo inválido",
                "Por favor, corrija o campo inválido",
                errorMessage
            );
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
