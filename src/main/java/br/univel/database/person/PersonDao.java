package br.univel.database.person;

import br.univel.database.DaoInterface;
import br.univel.model.person.Customer;
import br.univel.model.person.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Objects;

/**
 * Created by felipefrizzo on 8/17/16.
 */
public class PersonDao implements DaoInterface<Person, Long> {
    private static Session session;
    private static Transaction transaction;

    private static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }

    public static Session openSession() {
        if (session == null) {
            session = getSessionFactory().openSession();
        }
        return session;
    }

    public static Session openSessionWithTransaction() {
        if (session == null && transaction == null) {
            session = getSessionFactory().openSession();
            transaction = session.beginTransaction();
        }
        return session;
    }

    @Override
    public void closeSession() {
        session.close();
    }

    @Override
    public void closeSessionWithTransaction() {
        transaction.commit();
        session.close();
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public Transaction getTrasation() {
        return transaction;
    }

    @Override
    public void save(Person entity) {
        getSession().persist(entity);
    }

    @Override
    public void update(Person entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(Person entity) {
        getSession().delete(entity);
    }

    @Override
    public Person getById(Long id, Object object) {
        Class<?> cl = object.getClass();
        Person person = (Person) getSession().get(cl, id);
        return person;
    }

    @Override
    public List<Person> getAll(String from) {
        List<Person> persons = getSession().createQuery(from).list();
        return persons;
    }
}
