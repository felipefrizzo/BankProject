package br.univel.view.banking.popoutaccount;

import br.univel.Main;
import br.univel.database.account.AccountService;
import br.univel.database.agency.AgencyService;
import br.univel.model.account.Account;
import br.univel.model.account.TypeAccount;
import br.univel.model.agency.Agency;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PopOutController {

	private Main main;
	private AccountService accountService = new AccountService();
	private Account account;
	@FXML
	private TextField agency;

	@FXML
	private ComboBox<TypeAccount> typeAccount;

	@FXML
	private TextField holder;

	@FXML
	private TextField accountField;
	
	@FXML
	private void handleConfirm(){
		if (isInputValid(true)) {			
			main.showMainCustomerLayout();
			main.setAccount(account);
		}
	
	}

	@FXML
	void handleChangeAccount(KeyEvent event) {
		if (isInputValid(false)) {
			Agency a = new AgencyService().getByNumberAgency(agency.getText());
			account = accountService.getAccountByNumberAccountTypeAccountAgency(accountField.getText(),
					typeAccount.getSelectionModel().getSelectedItem(), a.getId());

			if (account == null) {
				showError("Conta errada", "Por favor, corrija os erros abaixo", "Conta selecionada invalida");
			} else {
				holder.setText(account.getClient().getName());
			}
		}
	}

	@FXML
	void onClickChangeAccount(MouseEvent event) {
		typeAccount.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TypeAccount>() {
			@Override
			public void changed(ObservableValue<? extends TypeAccount> observable, TypeAccount oldValue,
					TypeAccount newValue) {
				if (isInputValid(false)) {
					Agency a = new AgencyService().getByNumberAgency(agency.getText());
					account = accountService.getAccountByNumberAccountTypeAccountAgency(accountField.getText(),
							typeAccount.getSelectionModel().getSelectedItem(), a.getId());

					if (account == null) {
						showError("Conta errada", "Por favor, corrija os erros abaixo", "Conta selecionada invalida");
					} else {
						holder.setText(account.getClient().getName());
					}
				}

			}
		});
	}
	
	
	private boolean isInputValid(boolean isConfirmed){
		 String errorMessage = "";
	        if (this.agency.getText() == null || this.agency.getLength() == 0) {
	            errorMessage += "Informe o numero da agencia\n";
	        }
	        if (this.accountField.getText() == null || this.accountField.getLength() == 0) {
	            errorMessage += "Informe o numero da conta\n";
	        }
	        if (this.typeAccount.getSelectionModel().getSelectedItem() == null) {
	            errorMessage += "Informe o tipo da Conta\n";
	        }

	        if (errorMessage.equals("")) {
	            return true;
	        } else {
	            showError(
	                "Erros",
	                "Por favor corrija os campos inválidos",
	                errorMessage
	            );
	            return false;
	        }
	}
	
	  protected void showError(String title, String headerTitle, String contentText) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.initOwner(main.getPrimaryStage());
	        alert.setTitle(title);
	        alert.setHeaderText(headerTitle);
	        alert.setContentText(contentText);

	        alert.showAndWait();
	    }
}
