package br.univel.view.deposit;

import br.univel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by felipefrizzo on 9/12/16.
 */
public class DepositController {
    private Main main;

    @FXML
    private CheckBox isLogged;

    @FXML
    private TextField Agency;

    @FXML
    private TextField NumberAccount;

    @FXML
    private ComboBox<?> TypeAccount;

    @FXML
    private TextField Holder;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void handleConfirmDeposit(ActionEvent event) {

    }
}
