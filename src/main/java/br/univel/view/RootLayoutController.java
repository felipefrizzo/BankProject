package br.univel.view;

import br.univel.Main;
import br.univel.MainObserver;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by felipefrizzo on 8/30/16.
 */
public class RootLayoutController implements MainObserver{
    private Main main;

    @FXML
    private void initialize() {
        this.date.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()));
    }

    @FXML
    private Label date;

    @FXML
    private Label branchCode;

    @FXML
    private Label accountNumber;

    @FXML
    private Label typeAccount;

    @FXML
    private Label balance;

    @FXML
    private Label agencyLabel;

    @FXML
    private Label accountLabel;

    @FXML
    private Label typeAccountLabel;

    @FXML
    private Label balanceLabel;

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void showAccountInformation(Main main) {
        this.date.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date()));
        this.agencyLabel.setVisible(true);
        this.accountLabel.setVisible(true);
        this.typeAccountLabel.setVisible(true);
        this.balanceLabel.setVisible(true);

        this.branchCode.setVisible(true);
        this.accountNumber.setVisible(true);
        this.typeAccount.setVisible(true);
        this.balance.setVisible(true);

        this.branchCode.setText(main.getAccount().getAgency().getNumero());
        this.accountNumber.setText(main.getAccount().getAccountNumber().toString());
        this.typeAccount.setText(main.getAccount().getTypeAccount().name());
        this.balance.setText(String.valueOf(main.getAccount().getBalance()));
    }

    @Override
    public void disableAccountInformation(Main main) {
        this.agencyLabel.setVisible(false);
        this.accountLabel.setVisible(false);
        this.typeAccountLabel.setVisible(false);
        this.balanceLabel.setVisible(false);

        this.branchCode.setVisible(false);
        this.accountNumber.setVisible(false);
        this.typeAccount.setVisible(false);
        this.balance.setVisible(false);

        this.branchCode.setText("");
        this.accountNumber.setText("");
        this.typeAccount.setText("");
        this.balance.setText("");
    }
}
