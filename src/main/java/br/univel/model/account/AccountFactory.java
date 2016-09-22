package br.univel.model.account;

import br.univel.model.agency.Agency;
import br.univel.model.person.Customer;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by felipefrizzo on 9/3/16.
 */
public class AccountFactory {
    public AccountInterface create(TypeAccount typeAccount, Long accountNumber, Customer client, Agency agency, BigDecimal balance) {
        Objects.requireNonNull(typeAccount, "AccountInterface type cannot be null.");

        return new Account(typeAccount, accountNumber, client, agency, balance);
    }
}
