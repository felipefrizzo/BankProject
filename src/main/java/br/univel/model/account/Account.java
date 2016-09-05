package br.univel.model.account;

import br.univel.model.person.Person;

/**
 * Created by felipefrizzo on 9/3/16.
 */
public interface Account {
    public Long getId();

    public TypeAccount getTypeAccount();

    public Long getAccountNumber();

    public Person getClient();

    public Long getAgency();

}
