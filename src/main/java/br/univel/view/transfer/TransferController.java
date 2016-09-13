package br.univel.view.transfer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by felipefrizzo on 9/13/16.
 */
public class TransferController {

    @FXML
    private TextField agency;

    @FXML
    private TextField account;

    @FXML
    private ComboBox<?> typeAccount;

    @FXML
    private TextField holder;

    @FXML
    private TextField value;

    @FXML
    void handleConfirmTransfer(ActionEvent event) {

    }
}
