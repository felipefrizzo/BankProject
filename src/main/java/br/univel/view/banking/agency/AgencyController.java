package br.univel.view.banking.agency;

import br.univel.Main;
import br.univel.model.agency.Agency;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
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
	private TableColumn<Agency, String> columnumber;

	@FXML
	private TableColumn<Agency, String> columcity;

	@FXML
	private TableColumn<Agency, String> columname;

	@FXML
	private Button editAgency;

	@FXML
	private Button newAgency;

}
