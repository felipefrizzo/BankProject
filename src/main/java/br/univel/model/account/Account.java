package br.univel.model.account;

import br.univel.model.agency.Agency;
import br.univel.model.person.Person;

import java.math.BigDecimal;

/**
 * Created by felipefrizzo on 9/3/16.
 */
public interface Account {
    public Long getId();

    public TypeAccount getTypeAccount();

    public Long getAccountNumber();

    public Person getClient();

    public Agency getAgency();

    public BigDecimal getBalance();

}
