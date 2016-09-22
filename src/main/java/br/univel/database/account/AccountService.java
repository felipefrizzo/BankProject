package br.univel.database.account;

import br.univel.database.DaoService;
import br.univel.database.SessionFactory;
import br.univel.model.account.AccountInterface;
import br.univel.model.account.TypeAccount;
import br.univel.model.person.Person;

import java.util.List;

/**
 * Created by felipefrizzo on 9/5/16.
 */
public class AccountService implements DaoService<AccountInterface, Long> {
    private static AccountDao accountDao;
    private static SessionFactory sessionFactory;

    public AccountService() {
        accountDao = new AccountDao();
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void save(AccountInterface entity) {
        sessionFactory.openSessionWithTransaction();
        accountDao.save(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public void update(AccountInterface entity) {
        sessionFactory.openSessionWithTransaction();
        accountDao.update(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public void delete(AccountInterface entity) {
        sessionFactory.openSessionWithTransaction();
        accountDao.delete(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public AccountInterface getById(Long id, Object object) {
        sessionFactory.openSessionWithTransaction();
        AccountInterface account = accountDao.getById(id, object);
        sessionFactory.closeSessionWithTransaction();
        return account;
    }

    @Override
    public List<AccountInterface> getAll(String from) {
        sessionFactory.openSessionWithTransaction();
        List<AccountInterface> account = accountDao.getAll(from);
        sessionFactory.closeSessionWithTransaction();
        return account;
    }

    public AccountInterface getAccountByCustomer(final Person customer) {
        sessionFactory.openSessionWithTransaction();
        AccountInterface accounts = accountDao.getAccountByCustomer(customer);
        sessionFactory.closeSessionWithTransaction();
        return accounts;
    }

    public AccountInterface getAccountByNumber(String accountNumber) {
        sessionFactory.openSessionWithTransaction();
        AccountInterface account = accountDao.getAccountByNumber(Long.parseLong(accountNumber));
        sessionFactory.closeSessionWithTransaction();
        return account;
    }

    public AccountInterface getAccountByNumberAccountTypeAccountAgency(String accountNumber, TypeAccount typeAccount, String agency) {
        sessionFactory.openSessionWithTransaction();
        AccountInterface account = accountDao.getAccountByNumberAccountTypeAccountAgency(
                Long.parseLong(accountNumber),
                typeAccount.ordinal(),
                Integer.parseInt(agency)
        );
        sessionFactory.closeSessionWithTransaction();
        return account;
    }
}
