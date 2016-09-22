package br.univel.view.operation;

import br.univel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.math.BigDecimal;

/**
 * Created by felipefrizzo on 9/21/16.
 */
public class OperationController {
    private Main main;

    @FXML
    private Label operation;

    @FXML
    private Label value;


    public void setOperation(String operation) {
        this.operation.setText(operation);
    }

    public void setValue(BigDecimal value) {
        this.value.setText(String.valueOf(value));
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void handlePrint(ActionEvent event) {

    }

    @FXML
    void handleReturn(ActionEvent event) {
        main.showMainCustomerLayout();
        main.notifyObservers();
    }
}
