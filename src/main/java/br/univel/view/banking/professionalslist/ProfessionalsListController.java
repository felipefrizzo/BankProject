package br.univel.view.banking.professionalslist;

import br.univel.Main;
import br.univel.model.person.Banking;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ProfessionalsListController {

	private Main main;
	
	@FXML
	private TableColumn<Banking, String> name;

	@FXML
	private TableColumn<Banking, String> username;
}
