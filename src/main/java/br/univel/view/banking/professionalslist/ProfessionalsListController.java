package br.univel.view.banking.professionalslist;

import br.univel.Main;
import br.univel.model.person.Banking;
import br.univel.model.person.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProfessionalsListController {

	private Main main;
	
	public void setMain(Main main){
		this.main = main;
		bankingTable.setItems(new GetProfessionals().getObservableList());
	}

	@FXML
	public void initialize(){
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
	}

	@FXML
	private TableView bankingTable;
	
	@FXML
	private TableColumn<Banking, String> nameColumn;

	@FXML
	private TableColumn<Banking, String> usernameColumn;

    @FXML
    void handleBack(ActionEvent event) {
        main.showMainBankingLayout();
    }

    @FXML
    void handleEdit(ActionEvent event) {
        Person personSelected = (Person) bankingTable.getSelectionModel().getSelectedItem();
        if (personSelected != null) {
            main.showProfessionalsDetail(personSelected);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nenhuma seleção");
            alert.setHeaderText("Nenhum profissional Selecionado.");
            alert.setContentText("Por favor, selecione um profissional.");

            alert.showAndWait();
        }
    }

    @FXML
    void handleNew(ActionEvent event) {
        main.showProfessionalsDetail(null);
    }
}
