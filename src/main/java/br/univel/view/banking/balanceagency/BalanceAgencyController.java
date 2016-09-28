package br.univel.view.banking.balanceagency;

import br.univel.Main;
import br.univel.database.account.AccountService;
import br.univel.database.agency.AgencyService;
import br.univel.model.account.Account;
import br.univel.model.agency.Agency;
import br.univel.model.operationbanking.OperationBanking;
import br.univel.view.balance.GetOperationBanking;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by felipefrizzo on 27/09/16.
 */
public class BalanceAgencyController {
    private Main main;
    private ObservableList<OperationBanking> list;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private TableView<OperationBanking> operationBanking;
    @FXML
    private TableColumn<OperationBanking, Agency> agency;

    @FXML
    private TableColumn<OperationBanking, Account> account;

    @FXML
    private TableColumn<OperationBanking, String> operacao;

    @FXML
    private TableColumn<OperationBanking, BigDecimal> value;

    @FXML
    private TextField numberAgency;

    @FXML
    private Label deposit;

    @FXML
    private Label withdrawl;

    @FXML
    private Label balance;

    @FXML
    private DatePicker dateFrom;

    @FXML
    private DatePicker dateTo;

    @FXML
    void  handleBack() {
        main.showMainBankingLayout();
    }

    @FXML
    void handleGetAgenciesButton() {
        BigDecimal valueDeposit = new BigDecimal("0.00");
        BigDecimal valueWithdral = new BigDecimal("0.00");
        BigDecimal valueBalance = new BigDecimal("0.00");

        list = new GetAgencyBalance().getObservableList(numberAgency.getText());
        operationBanking.setItems(list);

        for (OperationBanking operationBanking: list) {
            if (operationBanking.getOperation().equalsIgnoreCase("deposito")) {
                valueDeposit = valueDeposit.add(operationBanking.getValue());
            } else if (operationBanking.getOperation().equalsIgnoreCase("saque")) {
                valueWithdral = valueWithdral.add(operationBanking.getValue());
            }
        }

        Agency agency = new AgencyService().getByNumberAgency(numberAgency.getText());
        List<Account> accounts = new AccountService().getByAgency(agency.getId());
        for (Account account: accounts) {
            valueBalance = valueBalance.add(account.getBalance());
        }

        showTable(String.valueOf(valueDeposit), String.valueOf(valueWithdral), String.valueOf(valueBalance));
    }

    @FXML
    void onClickGetBalanceByDate(MouseEvent mouseEvent) {
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
        BigDecimal valueDeposit = new BigDecimal("0.00");
        BigDecimal valueWithdral = new BigDecimal("0.00");
        BigDecimal valueBalance = new BigDecimal("0.00");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dateFrom = dateFormat.parse(from);
            Date dateTo = dateFormat.parse(to);
            list = new GetAgencyBalance(dateFrom, dateTo).getObservableList(numberAgency.getText());
            operationBanking.setItems(list);

            for (OperationBanking operationBanking: list) {
                if (operationBanking.getOperation().equalsIgnoreCase("deposito")) {
                    valueDeposit = valueDeposit.add(operationBanking.getValue());
                } else if (operationBanking.getOperation().equalsIgnoreCase("saque")) {
                    valueWithdral = valueWithdral.add(operationBanking.getValue());
                }
            }

            Agency agency = new AgencyService().getByNumberAgency(numberAgency.getText());
            List<Account> accounts = new AccountService().getByAgency(agency.getId());
            for (Account account: accounts) {
                valueBalance = valueBalance.add(account.getBalance());
            }

            showTable(String.valueOf(valueDeposit), String.valueOf(valueWithdral), String.valueOf(valueBalance));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void showTable(String valueDeposit, String valueWithdral, String valueBalance) {
        agency.setCellValueFactory(new PropertyValueFactory<>("account.agency.id"));
        account.setCellValueFactory(new PropertyValueFactory<>("account"));
        operacao.setCellValueFactory(new PropertyValueFactory<>("operation"));
        value.setCellValueFactory(new PropertyValueFactory<>("value"));

        deposit.setText(valueDeposit);
        withdrawl.setText(valueWithdral);
        balance.setText(valueBalance);

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
