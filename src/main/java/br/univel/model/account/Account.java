package br.univel.model.account;

import br.univel.model.agency.Agency;
import br.univel.model.person.Customer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by felipefrizzo on 9/3/16.
 */
@Entity
@Table(name = "account")
public class Account implements AccountInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private boolean isActive;
    @Column(name = "type_account")
    private TypeAccount typeAccount;
    @Column(name = "account_number")
    private Long accountNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client", nullable = false)
    private Customer client;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_agency", nullable = false)
    private Agency agency;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "opening_date")
    private Date openingDate;

    @Transient
    private List<AccountObserver> observers = new ArrayList<>();

    protected Account(final TypeAccount typeAccount, final Long accountNumber, final Customer client, final Agency agency, final BigDecimal balance) {
        this.typeAccount = typeAccount;
        this.accountNumber = accountNumber;
        this.client = client;
        this.agency = agency;
        this.balance = balance;
        this.openingDate = new Date();
        this.isActive = false;
    }

    protected Account() {
    }

    public void notifyObservers() {
        for (AccountObserver observer: observers) {
            observer.haveChanges(this);
        }
    }

    public void addObservers(AccountObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public TypeAccount getTypeAccount() {
        return typeAccount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public Long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public Customer getClient() {
        return client;
    }

    @Override
    public Agency getAgency() {
        return agency;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    @Override
    public AccountInterface setId(Long id) {
        this.id = id;
        notifyObservers();
        return this;
    }

    @Override
    public AccountInterface setTypeAccount(TypeAccount typeAccount) {
        this.typeAccount = typeAccount;
        notifyObservers();
        return this;
    }

    @Override
    public AccountInterface setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
        notifyObservers();
        return this;
    }

    @Override
    public AccountInterface setClient(Customer client) {
        this.client = client;
        notifyObservers();
        return this;
    }

    @Override
    public AccountInterface setAgency(Agency agency) {
        this.agency = agency;
        notifyObservers();
        return this;
    }

    @Override
    public AccountInterface setBalance(BigDecimal balance) {
        this.balance = balance;
        notifyObservers();
        return this;
    }
}
