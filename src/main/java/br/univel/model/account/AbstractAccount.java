package br.univel.model.account;

import br.univel.model.person.Customer;

import javax.persistence.*;

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
    @JoinColumn(name = "id_client")
    private Customer client;
    @Column(name = "id_agency")
    private Long agency;

    protected AbstractAccount(final TypeAccount typeAccount, final Long accountNumber, final Customer client, final Long agency) {
        this.typeAccount = typeAccount;
        this.accountNumber = accountNumber;
        this.client = client;
        this.agency = agency;
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
    public Long getAgency() {
        return agency;
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

    public Account setAgency(Long agency) {
        this.agency = agency;
        return this;
    }
}
