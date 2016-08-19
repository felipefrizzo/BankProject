package br.univel.database;

import java.util.List;

/**
 * Created by felipefrizzo on 8/17/16.
 */
public interface DaoService<T, S> {

    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);

    public T getById(S id, Object object);

    public List<T> getAll(String from);

}
