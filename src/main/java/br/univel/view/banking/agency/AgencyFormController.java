package br.univel.view.banking.agency;

import br.univel.Main;
import br.univel.database.agency.AgencyService;
import br.univel.model.agency.Agency;
import br.univel.model.agency.AgencyFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AgencyFormController {
    private Main main;
    private Agency agency;
    private AgencyService agencyService = new AgencyService();
    private AgencyFactory agencyFactory = new AgencyFactory();

    @FXML
    private TextField number;

    @FXML
    private TextField city;

    @FXML
    private TextField name;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
        showAgencyDetails(this.agency);
    }

    @FXML
    private void handleCreateAgency() {
        if (isInputValid()) {
            if (this.agency == null) {
                if (agencyService.getByNumberAgency(number.getText()) == null) {
                    Agency a = agencyFactory.create(name.getText(), number.getText(), city.getText());
                    agencyService.save(a);

                    main.showAgency();
                } else {
                    showError(
                        "Erro",
                        "Agência ja cadastrada",
                        "Esse numero de agencia ja esta cadastrado, por favor , digite outro "
                    );
                }
            } else {
                agency.setCidade(city.getText());
                agency.setName(name.getText());
                agency.setNumero(number.getText());
                agencyService.update(agency);

                main.showAgency();
            }
        }
    }


    private boolean isInputValid() {
        String errorMessage = "";
        if (this.number.getText() == null || this.number.getLength() == 0) {
            errorMessage += "Informe o numero da agencia\n";
        }
        if (this.city.getText() == null || this.city.getLength() == 0) {
            errorMessage += "Informe o nome da cidade\n";
        }
        if (this.name.getText() == null || this.name.getLength() == 0) {
            errorMessage += "Informe o nome da agencia\n";
        }

        if (errorMessage.equals("")) {
            return true;
        } else {
            showError(
                "Erros",
                "Por favor corrija os campos inválidos",
                errorMessage
            );
            return false;
        }

    }

    public void showAgencyDetails(Agency a) {
        if (a != null) {
            name.setText(a.getName());
            number.setText(a.getNumero());
            city.setText(a.getCidade());
        } else {
            name.setText("");
            number.setText("");
            city.setText("");
        }
    }

    protected void showError(String title, String headerTitle, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(main.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(headerTitle);
        alert.setContentText(contentText);

        alert.showAndWait();
    }
}

	