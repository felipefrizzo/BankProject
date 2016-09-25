package br.univel.view.banking.listingcustomers;

import java.math.BigDecimal;
import java.util.Date;

import br.univel.Main;
import br.univel.model.account.Account;
import br.univel.model.account.TypeAccount;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListingCustomersController {

	private Main main;
	private Account account;
	
	private void setMain(Main main) {
		this.main = main;
	}

	private void setAccount(Account account) {
		this.account = account;
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
	private TableColumn<Account, String> customerColumn;
	
	@FXML
	private void handlePrint(){
		
	}
	

}
