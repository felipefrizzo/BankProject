package br.univel.view;

import br.univel.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by felipefrizzo on 8/30/16.
 */
public class RootLayoutController {
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
}
