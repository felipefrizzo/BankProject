package br.univel.database;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by felipefrizzo on 8/17/16.
 */
public interface DaoInterface<T, I> {

    public void closeSession();

    public void closeSessionWithTransaction();

    public Session getSession();

    public Transaction getTrasation();

    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);

    public T getById(I id, Object object);

    public List<T> getAll(String from);

}
