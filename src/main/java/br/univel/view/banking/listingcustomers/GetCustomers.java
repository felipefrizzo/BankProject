package br.univel.view.banking.listingcustomers;

import br.univel.database.account.AccountService;
import br.univel.model.account.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipefrizzo on 25/09/16.
 */
public class GetCustomers {
    private AccountService accountService = new AccountService();
    private ObservableList<Account> observableList = FXCollections.observableArrayList();
    private List<Account> account = new ArrayList<Account>();

    public GetCustomers() {
        account = accountService.getAll("FROM Account");

        for (Account a: account) {
            observableList.add(a);
        }
    }

    public ObservableList<Account> getObservableList() {
        return observableList;
    }
}
