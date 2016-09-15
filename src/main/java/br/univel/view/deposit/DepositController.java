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
    private TextField agency;

    @FXML
    private TextField value;

    @FXML
    private TextField numberAccount;

    @FXML
    private ComboBox<?> typeAccount;

    @FXML
    private TextField holder;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void handleConfirmDeposit(ActionEvent event) {

    }
}
