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
        Agency agency = (Agency) sessionFactory.getSession().get(cl, id);
        return agency;
    }

    @Override
    public List<Agency> getAll(String from) {
        List<Agency> agency = sessionFactory.getSession().createQuery(from).list();
        return agency;
    }

    public Agency getByNumberAgency(Long numberAgency) {
        Agency agency = null;
        List<Agency> agencies = sessionFactory.getSession()
                .createQuery("where Agency number_agency = :number_agency")
                .setParameter("number_agency", numberAgency)
                .list();

        for (Agency a: agencies) {
            agency = a;
        }
        return agency;
    }
}
