package br.univel.model.account;

import br.univel.model.agency.Agency;
import br.univel.model.person.Customer;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by felipefrizzo on 9/3/16.
 */
@MappedSuperclass
public abstract class AbstractAccount implements Account{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
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

    protected AbstractAccount(final TypeAccount typeAccount, final Long accountNumber, final Customer client, final Agency agency, final BigDecimal balance) {
        this.typeAccount = typeAccount;
        this.accountNumber = accountNumber;
        this.client = client;
        this.agency = agency;
        this.balance = balance;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public TypeAccount getTypeAccount() {
        return typeAccount;
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
        return null;
    }

    public Account setId(Long id) {
        this.id = id;
        return this;
    }

    public Account setTypeAccount(TypeAccount typeAccount) {
        this.typeAccount = typeAccount;
        return this;
    }

    public Account setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Account setClient(Customer client) {
        this.client = client;
        return this;
    }

    public Account setAgency(Agency agency) {
        this.agency = agency;
        return this;
    }
}
