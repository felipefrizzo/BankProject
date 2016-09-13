package br.univel.database.account;

import br.univel.database.DaoService;
import br.univel.database.SessionFactory;
import br.univel.model.account.Account;

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
}
