package br.univel.view;

import br.univel.Main;
import br.univel.MainObserver;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.math.BigDecimal;

/**
 * Created by felipefrizzo on 8/30/16.
 */
public class RootLayoutController implements MainObserver{
    private Main main;
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

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void showAccountInformation(Main main) {
        this.branchCode.setVisible(true);
        this.accountNumber.setVisible(true);
        this.typeAccount.setVisible(true);
        this.balance.setVisible(true);

        this.branchCode.setText(main.getAccount().getAgency().getNumero());
        this.accountNumber.setText(main.getAccount().getAccountNumber().toString());
        this.typeAccount.setText(main.getAccount().getTypeAccount().name());
        this.balance.setText(String.valueOf(main.getAccount().getBalance()));
    }
}
