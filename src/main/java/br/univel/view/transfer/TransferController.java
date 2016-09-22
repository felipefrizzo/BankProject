package br.univel.view.transfer;

import br.univel.Main;
import br.univel.database.account.AccountService;
import br.univel.database.agency.AgencyService;
import br.univel.database.operationbanking.OperationBankingService;
import br.univel.model.account.Account;
import br.univel.model.account.TypeAccount;
import br.univel.model.agency.Agency;
import br.univel.model.operationbanking.OperationBanking;
import br.univel.model.operationbanking.OperationBankingFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by felipefrizzo on 9/13/16.
 */
public class TransferController {
    final private AccountService accountService = new AccountService();
    final private OperationBankingService operationBankingService = new OperationBankingService();
    private Main main;
    private Account account;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() {
        typeAccount.getItems().setAll(TypeAccount.CURRENT, TypeAccount.ELETRONIC, TypeAccount.SAVINGS);
    }

    @FXML
    private TextField agency;

    @FXML
    private TextField tfAccount;

    @FXML
    private ComboBox<TypeAccount> typeAccount;

    @FXML
    private TextField holder;

    @FXML
    private TextField value;

    @FXML
    void handleConfirmTransfer(ActionEvent event) {
        if (isInputValid(true)) {
            String value = this.value.getText().replace(",", ".");
            BigDecimal transferValue = new BigDecimal(value);

            if (isValidBalance(transferValue)) {
                if (main.showPasswordModal(main.getAccount().getClient())) {
                    BigDecimal mainBalance = main.getAccount().getBalance().subtract(transferValue);
                    BigDecimal accountBalance = account.getBalance().add(transferValue);
                    main.getAccount().setBalance(mainBalance);
                    account.setBalance(accountBalance);

                    accountService.update(account);
                    accountService.update(main.getAccount());

                    OperationBanking operationBanking = new OperationBankingFactory()
                            .create(account, "Transferencia de: " + main.getAccount().getClient().getName(), transferValue, new Date());
                    operationBankingService.save(operationBanking);

                    OperationBanking mainOperationBanking = new OperationBankingFactory()
                            .create(main.getAccount(), "Transferencia para: " + account.getClient().getName(), transferValue, new Date());
                    operationBankingService.save(mainOperationBanking);

                    main.showOperation("Tranferencia", transferValue);
                }
            } else {
                showError(
                    "Saldo insulficiente",
                    "Saldo insulficiente",
                    "Você não tem saldo sulficiente para completar essa transação"
                );
            }
        }
    }

    @FXML
    void handleBack(ActionEvent event) {
        main.showMainCustomerLayout();
        main.notifyObservers();
    }

    @FXML
    void handleGetAccount(KeyEvent event) {
        if (isInputValid(false)) {
            Agency a = new AgencyService().getByNumberAgency(agency.getText());
            account = accountService.getAccountByNumberAccountTypeAccountAgency(
                tfAccount.getText(),
                typeAccount.getSelectionModel().getSelectedItem(),
                a.getId()
            );
            if (account == null) {
                showError(
                    "Conta errada",
                    "Por favor, corrija os erros abaixo",
                    "Conta selecionada invalida"
                );
            } else {
                holder.setText(account.getClient().getName());
            }
        }
    }

    @FXML
    void onClickGetAccount(MouseEvent event) {
        typeAccount.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TypeAccount>() {
            @Override
            public void changed(ObservableValue<? extends TypeAccount> observable, TypeAccount oldValue, TypeAccount newValue) {
                if (isInputValid(false)) {
                    Agency a = new AgencyService().getByNumberAgency(agency.getText());
                    account = accountService.getAccountByNumberAccountTypeAccountAgency(
                            tfAccount.getText(),
                            typeAccount.getSelectionModel().getSelectedItem(),
                            a.getId()
                    );
                    if (account == null) {
                        showError(
                            "Conta errada",
                            "Por favor, corrija os erros abaixo",
                            "Conta inexistente, informe outra conta"
                        );
                    } else {
                        holder.setText(account.getClient().getName());
                    }
                }
            }
        });
    }

    protected Boolean isValidBalance(BigDecimal transferValue) {
        return !(this.main.getAccount().getBalance().compareTo(transferValue) == -1);
    }

    protected boolean isInputValid(boolean isComfirmed) {
        String errorMessage = "";
        if (agency.getText() == "" || agency.getLength() == 0) {
            errorMessage += "O campo agencia não pode estar em branco\n";
        }
        if (tfAccount.getText() == "" || tfAccount.getLength() == 0) {
            errorMessage += "O campo conta não pode estar em branco\n";
        }
        if (typeAccount.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "O campo tipo de conta não pode estar em branco\n";
        }
        if (isComfirmed && (value.getText() == "" || value.getLength() == 0)) {
            errorMessage += "O campo de valor não pode estar em branco\n";
        }

        if (isComfirmed && (account.getId() == main.getAccount().getId())) {
            showError(
                "Campos inválidos",
                "Por favor, corrija o campo inválido",
                "Não é posivel fazer tranferencia para mesma conta, por favor selecione outra"
            );
            return false;
        }

        if (errorMessage.equals("")) {
            return true;
        } else {
            if (isComfirmed) {
                showError(
                    "Campos inválidos",
                    "Por favor, corrija o campo inválido",
                    errorMessage
                );
            }
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
