package br.univel.view.banking.listingcustomers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class ListingCustomersController {

	@FXML
	private TableColumn<?, ?> number;

	@FXML
	private Button print;

	@FXML
	private TableColumn<?, ?> agency;

	@FXML
	private TableColumn<?, ?> balance;

	@FXML
	private TableColumn<?, ?> typeAccount;

	@FXML
	private TableColumn<?, ?> openedIn;

	@FXML
	private TableColumn<?, ?> customer;

}
