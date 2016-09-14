package br.univel.view.payment;

import br.univel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by felipefrizzo on 9/13/16.
 */
public class PaymentController {
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

    }

    @FXML
    void handleBack(ActionEvent event) {
        main.showMainCustomerLayout();
    }
}
