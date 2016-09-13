package br.univel.model.account;

import br.univel.model.agency.Agency;
import br.univel.model.person.Customer;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by felipefrizzo on 9/3/16.
 */
public class AccountFactory {
    public Account create(TypeAccount typeAccount, Long accountNumber, Customer client, Agency agency, BigDecimal balance) {
        Objects.requireNonNull(typeAccount, "Account type cannot be null.");

        switch (typeAccount) {
            case CURRENT:
                return new AccountCurrent(typeAccount, accountNumber, client, agency, balance);
            case SAVINGS:
                return new AccountSavings(typeAccount, accountNumber, client, agency, balance);
            case ELETRONIC:
                return new AccountEletronic(typeAccount, accountNumber, client, agency, balance);
            default:
                throw new RuntimeException("Type Account cannot be found");
        }
    }
}
