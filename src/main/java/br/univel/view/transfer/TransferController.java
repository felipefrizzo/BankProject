package br.univel.view.transfer;

import br.univel.Main;
import br.univel.model.account.TypeAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by felipefrizzo on 9/13/16.
 */
public class TransferController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() {
        typeAccount.getItems().setAll(TypeAccount.CURRENT, TypeAccount.ELETRONIC, TypeAccount.SAVINGS);
    }

    @FXML
    private TextField agency;

    @FXML
    private TextField account;

    @FXML
    private ComboBox<TypeAccount> typeAccount;

    @FXML
    private TextField holder;

    @FXML
    private TextField value;

    @FXML
    void handleConfirmTransfer(ActionEvent event) {

    }
}
