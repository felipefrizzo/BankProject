package br.univel.model.account;

import br.univel.model.agency.Agency;
import br.univel.model.person.Customer;
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

    public void addObservers(AccountObserver observer);

    public Account setId(Long id);

    public Account setTypeAccount(TypeAccount typeAccount);

    public Account setAccountNumber(Long accountNumber);

    public Account setClient(Customer client);

    public Account setAgency(Agency agency);

    public Account setBalance(BigDecimal balance);

}
