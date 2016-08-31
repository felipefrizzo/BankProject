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
    private Label Date;

    @FXML
    private Label BranchCode;

    @FXML
    private Label AccountNumber;

    @FXML
    private Label TypeAccount;

    @FXML
    private Label Balance;

    public void setMain(Main main) {
        this.main = main;
    }
}
