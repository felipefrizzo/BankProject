package br.univel.view.main;

import br.univel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by felipefrizzo on 9/12/16.
 */
public class MainCustomerController {
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

    }

    @FXML
    private void handleDeposit(ActionEvent event) {

    }

    @FXML
    private void handleFinish(ActionEvent event) {

    }

    @FXML
    private void handlePayment(ActionEvent event) {

    }

    @FXML
    private void handleTranfer(ActionEvent event) {

    }
}
