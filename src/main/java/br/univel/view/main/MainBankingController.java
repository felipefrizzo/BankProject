package br.univel.view.main;

import br.univel.Main;
import javafx.fxml.FXML;

public class MainBankingController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    
    @FXML
    public void handleBalance() {

    }

    @FXML
    public void handleProfessionals() {

    }

    @FXML
    public void handleInformation() {

    }

    @FXML
    public void handleAgencies() {

    }

    @FXML
    public void handleNewAccount() {
        main.showNewAccount();
    }

    @FXML
    public void handleCustomers() {

    }

}