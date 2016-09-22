package br.univel.view.operation;

import br.univel.Main;
import br.univel.model.operationbanking.OperationBanking;
import br.univel.reports.operation.OperationReport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipefrizzo on 9/21/16.
 */
public class OperationController {
    private OperationReport balanceReport = new OperationReport();
    private List<OperationBanking> operationBanking = new ArrayList<>();
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

    public void setOperationBanking(OperationBanking operationBanking) {
        this.operationBanking.add(operationBanking);
    }

    @FXML
    void handlePrint(ActionEvent event) {
        balanceReport.printReport(this.operationBanking);
    }

    @FXML
    void handleReturn(ActionEvent event) {
        main.showMainCustomerLayout();
        main.notifyObservers();
    }
}
