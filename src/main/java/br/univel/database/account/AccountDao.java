package br.univel.database.account;

import br.univel.database.DaoInterface;
import br.univel.database.SessionFactory;
import br.univel.model.account.Account;
import br.univel.model.person.Person;

import java.util.List;

/**
 * Created by felipefrizzo on 9/5/16.
 */
public class AccountDao implements DaoInterface<Account, Long>{
    private SessionFactory sessionFactory = SessionFactory.getInstance();

    @Override
    public void save(Account entity) {
        sessionFactory.getSession().save(entity);
    }

    @Override
    public void update(Account entity) {
        sessionFactory.getSession().update(entity);
    }

    @Override
    public void delete(Account entity) {
        sessionFactory.getSession().delete(entity);
    }

    @Override
    public Account getById(Long id, Object object) {
        Class<?> cl = object.getClass();
        Account account = (Account) sessionFactory.getSession().get(cl, id);
        return account;
    }

    @Override
    public List<Account> getAll(String from) {
        List<Account> account = sessionFactory.getSession().createQuery(from).list();
        return account;
    }

    public Account getAccountByCustomer(final Person customer) {
        List<Account> accounts = sessionFactory.getSession()
                .createQuery("from Account where id_client = :id_client")
                .setParameter("id_client", customer.getId()).list();

        for (Account account: accounts) {
            return account;
        }
        return null;
    }

    public Account getAccountByNumber(Long numberAccount) {
        List<Account> accounts = sessionFactory.getSession()
                .createQuery("from Account where account_number = :account_number")
                .setParameter("account_number", numberAccount)
                .list();
        for (Account account: accounts) {
            return account;
        }
        return null;
    }

    public Account getAccountByNumberAccountTypeAccountAgency(Long numberAccount, Integer typeAccount, Integer agency) {
        List<Account> accounts = sessionFactory.getSession()
            .createQuery(
                "from Account where" +
                    " account_number = :account_number" +
                    " and type_account = :type_account" +
                    " and id_agency = :id_agency"
            )
            .setParameter("account_number", numberAccount)
            .setParameter("id_agency", agency)
            .setParameter("type_account", typeAccount)
            .list();
        for (Account account: accounts) {
            return account;
        }
        return null;
    }
}
