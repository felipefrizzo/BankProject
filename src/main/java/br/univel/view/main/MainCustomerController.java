package br.univel.view.main;

import br.univel.Main;
import br.univel.MainObserver;
import br.univel.database.account.AccountService;
import br.univel.model.account.Account;
import br.univel.model.account.TypeAccount;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by felipefrizzo on 9/12/16.
 */
public class MainCustomerController implements MainObserver {
    final private AccountService accountService = new AccountService();
    private Main main;

    @FXML
    private Button cashWithdrawal;

    @FXML
    private Button payment;

    @FXML
    private Button deposit;

    @FXML
    private Hyperlink backToBanking;

    public void setMain(Main main) {
        this.main = main;
        if (this.main.isBanking()) {
            backToBanking.setVisible(true);
        }
    }

    @FXML
    private void handleBalance(ActionEvent event) {
        main.showBalance();
    }

    @FXML
    private void handleCashWithdrawl(ActionEvent event) {
        main.showCashWithdrawal();
    }

    @FXML
    private void handleDeposit(ActionEvent event) {
        main.showDeposit();
    }

    @FXML
    private void handleFinish(ActionEvent event) {
        if (main.getAccount().getBalance().compareTo(BigDecimal.ZERO) == 1) {
            showError(
                "error",
                "Não é possivel encerrar a conta",
                "Por favor, corrija os erros abaixos",
                "Sua conta ainda tem saldo, porfavor zere ela antes de encerrar"
            );
        } else {
            if (showError("confirmation", "Inativar conta", "Você realmente deseja inativar sua conta ?", "")) {
                main.getAccount().setActive(true);
                accountService.update(main.getAccount());
                main.showLoginLayout();
            }
        }
    }

    @FXML
    private void handlePayment(ActionEvent event) {
        main.showPayment();
    }

    @FXML
    private void handleTranfer(ActionEvent event) {
        main.showTransfer();
    }

    @Override
    public void showAccountInformation(Main main) {
        if (main.getAccount().getTypeAccount().equals(TypeAccount.ELETRONIC)) {
            cashWithdrawal.setDisable(true);
            deposit.setDisable(true);
        } else if (main.getAccount().getTypeAccount().equals(TypeAccount.SAVINGS)) {
            payment.setDisable(true);
        }
    }

    @Override
    public void disableAccountInformation(Main main) {

    }

    protected boolean showError(String type, String title, String headerTitle, String contentText) {
        Alert alert;
        if (type.equalsIgnoreCase("confirmation")) {
             alert = new Alert(Alert.AlertType.CONFIRMATION);
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
        }

        alert.initOwner(main.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(headerTitle);
        alert.setContentText(contentText);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            return true;
        }

        return false;
    }

    @FXML
    void handleBackToBanking(ActionEvent event) {
        main.showMainBankingLayout();
        main.notifyObserversCleanFields();
    }

    @FXML
    void handleLogout() {
        main.setBanking(null);
        main.setBanking(false);
        main.showLoginLayout();
        main.notifyObserversCleanFields();
    }
}
