package br.univel.database.person;

import br.univel.database.DaoInterface;
import br.univel.database.SessionFactory;
import br.univel.model.person.Person;

import java.util.List;

/**
 * Created by felipefrizzo on 8/17/16.
 */
public class PersonDao implements DaoInterface<Person, Long> {
    private SessionFactory sessionFactory = SessionFactory.getInstance();

    @Override
    public void save(Person entity) {
        sessionFactory.getSession().save(entity);
    }

    @Override
    public void update(Person entity) {
        sessionFactory.getSession().update(entity);
    }

    @Override
    public void delete(Person entity) {
        sessionFactory.getSession().delete(entity);
    }

    @Override
    public Person getById(Long id, Object object) {
        Class<?> cl = object.getClass();
        Person person = (Person) sessionFactory.getSession().get(cl, id);
        return person;
    }

    @Override
    public List<Person> getAll(String from) {
        List<Person> persons = sessionFactory.getSession().createQuery(from).list();
        return persons;
    }
}
