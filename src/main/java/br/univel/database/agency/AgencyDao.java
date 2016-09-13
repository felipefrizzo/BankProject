package br.univel.database.agency;

import br.univel.database.DaoInterface;
import br.univel.database.SessionFactory;
import br.univel.model.agency.Agency;

import java.util.List;

/**
 * Created by felipefrizzo on 9/6/16.
 */
public class AgencyDao implements DaoInterface<Agency, Long>{
    private SessionFactory sessionFactory = SessionFactory.getInstance();

    @Override
    public void save(Agency entity) {
        sessionFactory.getSession().save(entity);
    }

    @Override
    public void update(Agency entity) {
        sessionFactory.getSession().update(entity);
    }

    @Override
    public void delete(Agency entity) {
        sessionFactory.getSession().delete(entity);
    }

    @Override
    public Agency getById(Long id, Object object) {
        Class<?> cl = object.getClass();
        Agency account = (Agency) sessionFactory.getSession().get(cl, id);
        return account;
    }

    @Override
    public List<Agency> getAll(String from) {
        List<Agency> account = sessionFactory.getSession().createQuery(from).list();
        return account;
    }
}
