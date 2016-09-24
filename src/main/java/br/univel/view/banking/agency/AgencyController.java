package br.univel.view.banking.agency;

import br.univel.Main;
import br.univel.model.agency.Agency;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AgencyController {
	private Main main;

	public void setMain(Main main){
		this.main = main;
		agencyTable.setItems(new GetAgency().getObservableList());
	}

	@FXML
	public void initialize(){
		numberColumn.setCellValueFactory(new PropertyValueFactory<>("numero"));
		cityColumn.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
	}
	

	@FXML
	private TableView<Agency> agencyTable;
	
	@FXML
	private TableColumn<Agency, String> numberColumn;

	@FXML
	private TableColumn<Agency, String> cityColumn;

	@FXML
	private TableColumn<Agency, String> nameColumn;

	@FXML
	private void handleNew(){
		main.showNewAgency(null);
	}
	
	@FXML
	private void handleEdit() {
        Agency selectedAgency = agencyTable.getSelectionModel().getSelectedItem();
        if (selectedAgency != null) {
			main.showNewAgency(selectedAgency);

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Nenhuma seleção");
			alert.setHeaderText("Nenhuma Agência Selecionada.");
			alert.setContentText("Por favor, selecione uma agência.");

			alert.showAndWait();
		}
	}
}
