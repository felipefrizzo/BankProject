package br.univel.database.agency;

import br.univel.database.DaoService;
import br.univel.database.SessionFactory;
import br.univel.model.agency.Agency;

import java.util.List;

/**
 * Created by felipefrizzo on 9/6/16.
 */
public class AgencyService implements DaoService<Agency, Long>{
    private static AgencyDao agencyDao;
    private static SessionFactory sessionFactory;

    public AgencyService() {
        agencyDao = new AgencyDao();
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void save(Agency entity) {
        sessionFactory.openSessionWithTransaction();
        agencyDao.save(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public void update(Agency entity) {
        sessionFactory.openSessionWithTransaction();
        agencyDao.update(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public void delete(Agency entity) {
        sessionFactory.openSessionWithTransaction();
        agencyDao.delete(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public Agency getById(Long id, Object object) {
        sessionFactory.openSessionWithTransaction();
        Agency agency = agencyDao.getById(id, object);
        sessionFactory.closeSessionWithTransaction();
        return agency;
    }

    @Override
    public List<Agency> getAll(String from) {
        sessionFactory.openSessionWithTransaction();
        List<Agency> agency = agencyDao.getAll(from);
        sessionFactory.closeSessionWithTransaction();
        return agency;
    }
}
