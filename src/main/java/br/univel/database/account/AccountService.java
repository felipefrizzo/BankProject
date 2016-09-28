package br.univel.database.account;

import br.univel.database.DaoService;
import br.univel.database.SessionFactory;
import br.univel.model.account.Account;
import br.univel.model.account.TypeAccount;
import br.univel.model.person.Person;

import java.util.List;

/**
 * Created by felipefrizzo on 9/5/16.
 */
public class AccountService implements DaoService<Account, Long> {
    private static AccountDao accountDao;
    private static SessionFactory sessionFactory;

    public AccountService() {
        accountDao = new AccountDao();
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void save(Account entity) {
        sessionFactory.openSessionWithTransaction();
        accountDao.save(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public void update(Account entity) {
        sessionFactory.openSessionWithTransaction();
        accountDao.update(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public void delete(Account entity) {
        sessionFactory.openSessionWithTransaction();
        accountDao.delete(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public Account getById(Long id, Object object) {
        sessionFactory.openSessionWithTransaction();
        Account account = accountDao.getById(id, object);
        sessionFactory.closeSessionWithTransaction();
        return account;
    }

    @Override
    public List<Account> getAll(String from) {
        sessionFactory.openSessionWithTransaction();
        List<Account> account = accountDao.getAll(from);
        sessionFactory.closeSessionWithTransaction();
        return account;
    }

    public Account getAccountByCustomer(final Person customer) {
        sessionFactory.openSessionWithTransaction();
        Account accounts = accountDao.getAccountByCustomer(customer);
        sessionFactory.closeSessionWithTransaction();
        return accounts;
    }

    public Account getAccountByNumber(String accountNumber) {
        sessionFactory.openSessionWithTransaction();
        Account account = accountDao.getAccountByNumber(Long.parseLong(accountNumber));
        sessionFactory.closeSessionWithTransaction();
        return account;
    }

    public Account getAccountByNumberAccountTypeAccountAgency(String accountNumber, TypeAccount typeAccount, Long agency) {
        sessionFactory.openSessionWithTransaction();
        Account account = accountDao.getAccountByNumberAccountTypeAccountAgency(
                Long.parseLong(accountNumber),
                typeAccount.ordinal(),
                Long.valueOf(agency).intValue()
        );
        sessionFactory.closeSessionWithTransaction();
        return account;
    }

    public List<Account> getByAgency(Long agency) {
        sessionFactory.openSessionWithTransaction();
        List<Account> account = accountDao.getAccountByAgency(agency);
        sessionFactory.closeSessionWithTransaction();
        return account;
    }
}
