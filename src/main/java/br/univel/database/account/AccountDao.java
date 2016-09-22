package br.univel.database.account;

import br.univel.database.DaoInterface;
import br.univel.database.SessionFactory;
import br.univel.model.account.AccountInterface;
import br.univel.model.person.Person;

import java.util.List;

/**
 * Created by felipefrizzo on 9/5/16.
 */
public class AccountDao implements DaoInterface<AccountInterface, Long>{
    private SessionFactory sessionFactory = SessionFactory.getInstance();

    @Override
    public void save(AccountInterface entity) {
        sessionFactory.getSession().save(entity);
    }

    @Override
    public void update(AccountInterface entity) {
        sessionFactory.getSession().update(entity);
    }

    @Override
    public void delete(AccountInterface entity) {
        sessionFactory.getSession().delete(entity);
    }

    @Override
    public AccountInterface getById(Long id, Object object) {
        Class<?> cl = object.getClass();
        AccountInterface account = (AccountInterface) sessionFactory.getSession().get(cl, id);
        return account;
    }

    @Override
    public List<AccountInterface> getAll(String from) {
        List<AccountInterface> account = sessionFactory.getSession().createQuery(from).list();
        return account;
    }

    public AccountInterface getAccountByCustomer(final Person customer) {
        List<AccountInterface> accounts = sessionFactory.getSession()
                .createQuery("from AccountCurrent where id_client = :id_client")
                .setParameter("id_client", customer.getId()).list();

        for (AccountInterface account: accounts) {
            return account;
        }
        return null;
    }

    public AccountInterface getAccountByNumber(Long numberAccount) {
        List<AccountInterface> accounts = sessionFactory.getSession()
                .createQuery("from AccountCurrent where account_number = :account_number")
                .setParameter("account_number", numberAccount)
                .list();
        for (AccountInterface account: accounts) {
            return account;
        }
        return null;
    }

    public AccountInterface getAccountByNumberAccountTypeAccountAgency(Long numberAccount, Integer typeAccount, Integer agency) {
        List<AccountInterface> accounts = sessionFactory.getSession()
            .createQuery(
                "from AccountCurrent where" +
                    " account_number = :account_number" +
                    " and type_account = :type_account" +
                    " and id_agency = :id_agency"
            )
            .setParameter("account_number", numberAccount)
            .setParameter("id_agency", agency)
            .setParameter("type_account", typeAccount)
            .list();
        for (AccountInterface account: accounts) {
            return account;
        }
        return null;
    }
}
