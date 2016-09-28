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
        main.showAgencyBalance();
    }

    @FXML
    public void handleProfessionals() {
        main.showProfessionals();
    }

    @FXML
    public void handleInformation() {
        main.showPopOut();
    }

    @FXML
    public void handleAgencies() {
    	main.showAgency();
    }

    @FXML
    public void handleNewAccount() {
        main.showNewAccount();
    }

    @FXML
    public void handleCustomers() {
        main.showListCustomer();
    }

    @FXML
    void handleLogout() {
        main.setBanking(null);
        main.setBanking(false);
        main.showLoginLayout();
        main.notifyObserversCleanFields();
    }
}
