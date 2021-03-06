package br.univel.model.account;

import br.univel.model.agency.Agency;
import br.univel.model.person.Customer;
import br.univel.model.person.Person;

import java.math.BigDecimal;

/**
 * Created by felipefrizzo on 9/3/16.
 */
public interface AccountInterface {
    public Long getId();

    public boolean isActive();

    public TypeAccount getTypeAccount();

    public Long getAccountNumber();

    public Person getClient();

    public Agency getAgency();

    public BigDecimal getBalance();

    public void addObservers(AccountObserver observer);

    public AccountInterface setId(Long id);

    public void setActive(boolean active);

    public AccountInterface setTypeAccount(TypeAccount typeAccount);

    public AccountInterface setAccountNumber(Long accountNumber);

    public AccountInterface setClient(Customer client);

    public AccountInterface setAgency(Agency agency);

    public AccountInterface setBalance(BigDecimal balance);

}
