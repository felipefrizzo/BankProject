package br.univel.view.balance;

import br.univel.Main;
import br.univel.database.operationbanking.OperationBankingService;
import br.univel.model.operationbanking.OperationBanking;
import br.univel.reports.balance.BalanceReport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    void handlePrint(ActionEvent event) {
        List<OperationBanking> list = operationBankingService.getAllByAccount(main.getAccount().getId());
        balanceReport.printReport(list);
    }

    @FXML
    void handleBackToHome(ActionEvent event) {
        main.showMainCustomerLayout();
        main.notifyObservers();
    }

    @FXML
    void onClickGetDateFrom(MouseEvent mouseEvent) {
        dateFrom.setOnAction(event -> {
            if (dateFrom.getValue() != null && dateTo.getValue() != null) {
                if (dateTo.getValue().compareTo(dateFrom.getValue()) >= 0) {
                    getOperationsByDate(String.valueOf(dateFrom.getValue()), String.valueOf(dateTo.getValue()));
                } else {
                    showError("Data invalida", "Por favor, corrija os erros abaixo", "A data selecionada não é valida");
                }
            }
        });
        dateTo.setOnAction(event -> {
            if (dateFrom.getValue() != null && dateTo.getValue() != null) {
                if (dateTo.getValue().compareTo(dateFrom.getValue()) >= 0) {
                    getOperationsByDate(String.valueOf(dateFrom.getValue()), String.valueOf(dateTo.getValue()));
                } else {
                    showError("Data invalida", "Por favor, corrija os erros abaixo", "A data selecionada não é valida");
                }
            }
        });
    }

    protected void getOperationsByDate(String from, String to) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dateFrom = dateFormat.parse(from);
            Date dateTo = dateFormat.parse(to);

            operationTable.setItems(new GetOperationBanking(
                this.main.getAccount().getId(),
                dateFrom,
                dateTo)
                .getObservableList()
            );

            initialize();
        } catch (ParseException e) {
            e.printStackTrace();
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
