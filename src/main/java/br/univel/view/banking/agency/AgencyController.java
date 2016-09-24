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

	private Agency agency = new Agency();
	
	public void setMain(Main main){
		this.main = main;
	}
	
	public void initialize(){
		columnumber.setCellValueFactory(new PropertyValueFactory <> ("numero"));
		columcity.setCellValueFactory(new PropertyValueFactory <> ("cidade"));
		columname.setCellValueFactory(new PropertyValueFactory <> ("name"));
	}
	

	@FXML
	private TableView<Agency> agencyTable;
	
	@FXML
	private TableColumn<Agency, String> columnumber;

	@FXML
	private TableColumn<Agency, String> columcity;

	@FXML
	private TableColumn<Agency, String> columname;
	
	@FXML
	private void handleNew(){
		Agency agency = new Agency();
		main.showNewAgency(agency);
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
