package br.univel.view.banking.balanceagency;

import br.univel.Main;
import br.univel.model.account.Account;
import br.univel.model.agency.Agency;
import br.univel.model.operationbanking.OperationBanking;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;

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
    void  handleBack() {
        main.showMainBankingLayout();
    }

    @FXML
    void handleGetAgenciesButton() {
        BigDecimal valueDeposit = new BigDecimal("0.00");
        BigDecimal valueWithdral = new BigDecimal("0.00");
        BigDecimal valueBalance = new BigDecimal("0.00");

        operationBanking.setItems(new GetAgencyBalance().getObservableList(numberAgency.getText()));
        list = new GetAgencyBalance().getObservableList(numberAgency.getText());

        for (OperationBanking operationBanking: list) {
            valueBalance = valueBalance.add(operationBanking.getAccount().getBalance());
            if (operationBanking.getOperation().equalsIgnoreCase("deposito")) {
                valueDeposit = valueDeposit.add(operationBanking.getValue());
            } else if (operationBanking.getOperation().equalsIgnoreCase("saque")) {
                valueWithdral = valueWithdral.add(operationBanking.getValue());
            }
        }

        showTable(String.valueOf(valueDeposit), String.valueOf(valueWithdral), String.valueOf(valueBalance));
    }

    private void showTable(String valueDeposit, String valueWithdral, String valueBalance) {
        agency.setCellValueFactory(new PropertyValueFactory<>("account.account_number"));
        account.setCellValueFactory(new PropertyValueFactory<>("account"));
        operacao.setCellValueFactory(new PropertyValueFactory<>("operation"));
        value.setCellValueFactory(new PropertyValueFactory<>("value"));

        deposit.setText(valueDeposit);
        withdrawl.setText(valueWithdral);
        balance.setText(valueBalance);

    }
}
