package br.univel.database;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by felipefrizzo on 8/24/16.
 */
public class SessionFactory {
    private Session session;
    private Transaction transaction;
    private static org.hibernate.SessionFactory sessionFactory;
    private static SessionFactory instance;

    private SessionFactory() {
    }

    public static SessionFactory getInstance(){
        if(instance == null){
            instance = new SessionFactory();
            instance.configHibernateFactory();
        }
        return instance;
    }

    private static void configHibernateFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Session openSession() {
        session = sessionFactory.openSession();
        return session;
    }

    public Session openSessionWithTransaction() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public void closeSessionWithTransaction() {
        transaction.commit();
        session.close();
    }

    public Session getSession() {
        return session;
    }

    public Transaction getTrasation() {
        return transaction;
    }

}
