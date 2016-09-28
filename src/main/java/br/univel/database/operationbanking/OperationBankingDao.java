package br.univel.database.operationbanking;

import br.univel.database.DaoInterface;
import br.univel.database.SessionFactory;
import br.univel.model.operationbanking.OperationBanking;

import java.util.Date;
import java.util.List;

/**
 * Created by felipefrizzo on 9/21/16.
*/
public class OperationBankingDao implements DaoInterface<OperationBanking, Long> {
    private SessionFactory sessionFactory = SessionFactory.getInstance();

    @Override
    public void save(OperationBanking entity) {
        sessionFactory.getSession().save(entity);
    }

    @Override
    public void update(OperationBanking entity) {
        sessionFactory.getSession().update(entity);
    }

    @Override
    public void delete(OperationBanking entity) {
        sessionFactory.getSession().delete(entity);
    }

    @Override
    public OperationBanking getById(Long id, Object object) {
        Class<?> cl = object.getClass();
        OperationBanking operationBanking = (OperationBanking) sessionFactory.getSession().get(cl, id);
        return operationBanking;
    }

    @Override
    public List<OperationBanking> getAll(String from) {
        List<OperationBanking> operationBankings = sessionFactory.getSession().createQuery(from).list();
        return operationBankings;
    }

    public List<OperationBanking> getAllByAccount(Long account) {
        List<OperationBanking> operationBanking = sessionFactory.getSession()
                .createQuery("from OperationBanking where id_account = :id_account")
                .setParameter("id_account", account)
                .list();

        return operationBanking;
    }

    public List<OperationBanking> getAllByAccountByDate(Long account, Date dateFrom, Date dateTo) {
        List<OperationBanking> operationBanking = sessionFactory.getSession()
                .createQuery("from OperationBanking where date between :date_from and :date_to and id_account = :id_account")
                .setParameter("id_account", account)
                .setParameter("date_from", dateFrom)
                .setParameter("date_to", dateTo)
                .list();

        return operationBanking;
    }
}
