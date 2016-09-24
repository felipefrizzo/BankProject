package br.univel.view.banking.listingcustomers;

import java.math.BigDecimal;
import java.util.Date;

import br.univel.model.account.TypeAccount;
import br.univel.model.person.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListingCustomersController {

	@FXML
	private TableView<Customer> tableCustomers;
	
	@FXML
	private TableColumn<Customer, String> number;

	@FXML
	private TableColumn<Customer, String> agency;

	@FXML
	private TableColumn<Customer, BigDecimal> balance;

	@FXML
	private TableColumn<Customer, TypeAccount> typeAccount;

	@FXML
	private TableColumn<Customer, Date> openedIn;

	@FXML
	private TableColumn<Customer, String> customer;
	
	@FXML
	private Button print;

}
