package br.univel.view.banking.listingcustomers;

import br.univel.Main;
import br.univel.database.account.AccountService;
import br.univel.model.account.Account;
import br.univel.model.account.TypeAccount;
import br.univel.model.agency.Agency;
import br.univel.model.person.Person;
import br.univel.reports.customers.CustomerReport;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ListingCustomersController {
	private CustomerReport customerReport = new CustomerReport();
	private AccountService accountService = new AccountService();
	private Main main;

	public void setMain(Main main) {
		this.main = main;
        tableCustomers.setItems(new GetCustomers().getObservableList());
	}

	@FXML
	public void initialize(){
		numberColumn.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
		agencyColumn.setCellValueFactory(new PropertyValueFactory<>("agency"));
		customerColumn.setCellValueFactory(new PropertyValueFactory<>("client"));
		typeAccountColumn.setCellValueFactory(new PropertyValueFactory<>("typeAccount"));
		balanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));
		openedInColumn.setCellValueFactory(new PropertyValueFactory<>("openingDate"));
	}
	
	@FXML
	private TableView<Account> tableCustomers;
	
	@FXML
	private TableColumn<Account, String> numberColumn;

	@FXML
	private TableColumn<Account, String> agencyColumn;

	@FXML
	private TableColumn<Account, BigDecimal> balanceColumn;

	@FXML
	private TableColumn<Account, TypeAccount> typeAccountColumn;

	@FXML
	private TableColumn<Account, Date> openedInColumn;

	@FXML
	private TableColumn<Person, String> customerColumn;
	
	@FXML
	private void handlePrint(){
		List<Account> list = accountService.getAll("FROM Account");
		customerReport.printReport(list);
	}
}
