package br.univel.view.balance;

import br.univel.Main;
import br.univel.database.operationbanking.OperationBankingService;
import br.univel.model.operationbanking.OperationBanking;
import br.univel.reports.balance.BalanceReport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by felipefrizzo on 9/22/16.
 */
public class BalanceController {
    private Main main;
    private OperationBankingService operationBankingService = new OperationBankingService();
    private BalanceReport balanceReport = new BalanceReport();

    @FXML
    private void initialize() {
        columnOperation.setCellValueFactory(new PropertyValueFactory<>("operation"));
        columnValue.setCellValueFactory(new PropertyValueFactory<>("value"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    public void setMain(Main main) {
        this.main = main;
        operationTable.setItems(new GetOperationBanking(this.main.getAccount().getId()).getObservableList());
        showBalance.setText(String.valueOf(this.main.getAccount().getBalance()));
    }

    @FXML
    private TableView<OperationBanking> operationTable;

    @FXML
    private TableColumn<OperationBanking, String> columnOperation;

    @FXML
    private TableColumn<OperationBanking, Date> columnDate;

    @FXML
    private TableColumn<OperationBanking, BigDecimal> columnValue;

    @FXML
    private Label showBalance;

    @FXML
    private DatePicker dateFrom;

    @FXML
    private DatePicker dateTo;

    @FXML
    void handleAdvanceDay(ActionEvent event) {

    }

    @FXML
    void handleAdvanceMonth(ActionEvent event) {

    }

    @FXML
    void handleAdvanceYear(ActionEvent event) {

    }

    @FXML
    void handleBackDay(ActionEvent event) {

    }

    @FXML
    void handleBackMonth(ActionEvent event) {

    }

    @FXML
    void handleBackYear(ActionEvent event) {

    }

    @FXML
    void handlePrint(ActionEvent event) {
        List<OperationBanking> list = operationBankingService.getAllByAccount(main.getAccount().getId());
        balanceReport.printReport(list);
    }

    @FXML
    void handleBackToHome(ActionEvent event) {
        main.showMainCustomerLayout();
        main.notifyObservers();
    }
}
