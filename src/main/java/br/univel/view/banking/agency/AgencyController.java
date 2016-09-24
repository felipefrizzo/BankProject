package br.univel.view.banking.agency;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class AgencyController {

	@FXML
	private TableColumn<?, ?> number;

	@FXML
	private TableColumn<?, ?> city;

	@FXML
	private Button editAgency;

	@FXML
	private TableColumn<?, ?> name;

	@FXML
	private Button newAgency;

}
