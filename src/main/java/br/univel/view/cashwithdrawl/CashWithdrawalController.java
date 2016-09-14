package br.univel.view.cashwithdrawl;

import br.univel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by felipefrizzo on 9/12/16.
 */
public class CashWithdrawalController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private TextField withdrawalValue;

    @FXML
    void handleConfirmWithdrawal(ActionEvent event) {

    }

    @FXML
    void handleWithdrawal50(ActionEvent event) {

    }

    @FXML
    void handleWithdrawal100(ActionEvent event) {

    }

    @FXML
    void handleWithdrawal200(ActionEvent event) {

    }

    @FXML
    void handleWithdrawal300(ActionEvent event) {

    }

    @FXML
    void handleWithdrawal500(ActionEvent event) {

    }

    @FXML
    void handleBack(ActionEvent event) {
        main.showMainCustomerLayout();
    }
}
