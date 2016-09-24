package br.univel.view.banking.listingcustomers;

import br.univel.model.person.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListingCustomersController {

	@FXML
	private TableView<Customer> tableCustomers;
	
	@FXML
	private TableColumn<Customer, ?> number;

	@FXML
	private TableColumn<Customer, ?> agency;

	@FXML
	private TableColumn<Customer, ?> balance;

	@FXML
	private TableColumn<Customer, ?> typeAccount;

	@FXML
	private TableColumn<Customer, ?> openedIn;

	@FXML
	private TableColumn<Customer, ?> customer;
	
	@FXML
	private Button print;

}
