package br.univel.model.account;

import br.univel.model.agency.Agency;
import br.univel.model.person.Customer;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by felipefrizzo on 9/3/16.
 */
@Entity
@Table(name = "account")
public class AccountEletronic extends AbstractAccount {
    protected AccountEletronic(final TypeAccount typeAccount, final Long accountNumber, final Customer client, final Agency agency, final BigDecimal balance) {
        super(typeAccount, accountNumber, client, agency, balance);
    }

    protected AccountEletronic() {
    }
}
