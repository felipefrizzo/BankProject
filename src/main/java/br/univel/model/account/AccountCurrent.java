package br.univel.model.account;

import br.univel.model.person.Person;

/**
 * Created by felipefrizzo on 9/3/16.
 */
public class AccountCurrent extends AbstractAccount {
    protected AccountCurrent(final TypeAccount typeAccount, final Long accountNumber, final Person client, final Long agency) {
        super(typeAccount, accountNumber, client, agency);
    }
}
