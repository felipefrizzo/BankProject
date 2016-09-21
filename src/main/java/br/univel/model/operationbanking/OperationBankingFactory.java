package br.univel.model.operationbanking;

import br.univel.model.account.Account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Created by felipefrizzo on 9/21/16.
 */
public class OperationBankingFactory {
    public OperationBanking create(final Account account, final String operation, final BigDecimal value, final Date date) {
        Objects.requireNonNull(account, "Name cannot be null");

        return new OperationBanking(account, operation, value, date);
    }
}
