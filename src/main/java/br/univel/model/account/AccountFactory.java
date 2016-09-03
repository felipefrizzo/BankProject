package br.univel.model.account;

import br.univel.model.person.Person;

import java.util.Objects;

/**
 * Created by felipefrizzo on 9/3/16.
 */
public class AccountFactory {
    public Account create(TypeAccount typeAccount, Long accountNumber, Person client, Long agency) {
        Objects.requireNonNull(typeAccount, "Account type cannot be null.");

        switch (typeAccount) {
            case CURRENT:
                return null;
            case SAVINGS:
                return null;
            case ELETRONIC:
                return null;
            default:
                throw new RuntimeException("Type Account cannot be found");
        }
    }
}
