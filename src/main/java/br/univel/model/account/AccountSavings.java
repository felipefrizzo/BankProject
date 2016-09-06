package br.univel.model.account;

import br.univel.model.person.Customer;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by felipefrizzo on 9/3/16.
 */
@Entity
@Table(name = "account")
public class AccountSavings extends AbstractAccount {
    protected AccountSavings(final TypeAccount typeAccount, final Long accountNumber, final Customer client, final Long agency) {
        super(typeAccount, accountNumber, client, agency);
    }
}
