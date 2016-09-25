package br.univel.view.banking.professionalslist;

import br.univel.Main;
import br.univel.model.person.Banking;
import br.univel.view.banking.agency.GetAgency;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProfessionalsListController {

	private Main main;
	
	public void setMain(Main main){
		this.main = main;
		bankingTable.setItems(new GetAgency().getObservableList());
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
}
