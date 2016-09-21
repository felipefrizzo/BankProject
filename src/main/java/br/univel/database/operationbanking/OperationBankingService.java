package br.univel.database.operationbanking;

import br.univel.database.DaoService;
import br.univel.database.SessionFactory;
import br.univel.model.operationbanking.OperationBanking;

import java.util.List;

/**
 * Created by felipefrizzo on 9/21/16.
 */
public class OperationBankingService implements DaoService<OperationBanking, Long> {
    private static OperationBankingDao operationBankingDao;
    private static SessionFactory sessionFactory;

    public OperationBankingService() {
        operationBankingDao = new OperationBankingDao();
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void save(OperationBanking entity) {
        sessionFactory.openSessionWithTransaction();
        operationBankingDao.save(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public void update(OperationBanking entity) {
        sessionFactory.openSessionWithTransaction();
        operationBankingDao.update(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public void delete(OperationBanking entity) {
        sessionFactory.openSessionWithTransaction();
        operationBankingDao.delete(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public OperationBanking getById(Long id, Object object) {
        sessionFactory.openSessionWithTransaction();
        OperationBanking operationBanking = operationBankingDao.getById(id, object);
        sessionFactory.closeSessionWithTransaction();
        return operationBanking;
    }

    @Override
    public List<OperationBanking> getAll(String from) {
        sessionFactory.openSessionWithTransaction();
        List<OperationBanking> operationBanking = operationBankingDao.getAll(from);
        sessionFactory.closeSessionWithTransaction();
        return operationBanking;
    }
}
