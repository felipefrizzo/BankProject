package br.univel.view.main;

import br.univel.Main;
import br.univel.MainObserver;
import br.univel.model.account.Account;
import br.univel.model.account.TypeAccount;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by felipefrizzo on 9/12/16.
 */
public class MainCustomerController implements MainObserver {
    private Main main;

    @FXML
    private Button cashWithdrawal;

    @FXML
    private Button transfer;

    @FXML
    private Button balance;

    @FXML
    private Button payment;

    @FXML
    private Button deposit;

    @FXML
    private Button finish;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleBalance(ActionEvent event) {

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
        Platform.exit();
        System.exit(0);
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
}
