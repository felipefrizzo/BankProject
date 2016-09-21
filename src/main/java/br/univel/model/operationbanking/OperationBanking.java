package br.univel.model.operationbanking;

import br.univel.model.account.Account;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by felipefrizzo on 9/21/16.
 */
@Entity
@Table(name = "operation_banking")
public class OperationBanking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_account")
    private Account account;
    @Column(name = "operation")
    private String operation;
    @Column(name = "value")
    private BigDecimal value;
    @Column(name = "date")
    private Date date;

    public OperationBanking(final Account account, final String operation, final BigDecimal value, final Date date) {
        this.account = account;
        this.operation = operation;
        this.value = value;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
