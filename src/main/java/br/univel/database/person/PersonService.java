package br.univel.database.person;

import br.univel.database.SessionFactory;
import br.univel.database.DaoService;
import br.univel.model.person.Person;

import java.util.List;

/**
 * Created by felipefrizzo on 8/17/16.
 */
public class PersonService implements DaoService<Person, Long> {
    private static PersonDao personDao;
    private static SessionFactory sessionFactory;

    public PersonService() {
        personDao = new PersonDao();
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void save(Person entity) {
        sessionFactory.openSessionWithTransaction();
        personDao.save(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public void update(Person entity) {
        sessionFactory.openSessionWithTransaction();
        personDao.update(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public void delete(Person entity) {
        sessionFactory.openSessionWithTransaction();
        personDao.delete(entity);
        sessionFactory.closeSessionWithTransaction();
    }

    @Override
    public Person getById(Long id, Object object) {
        sessionFactory.openSessionWithTransaction();
        Person person = personDao.getById(id, object);
        sessionFactory.closeSessionWithTransaction();
        return person;
    }

    @Override
    public List<Person> getAll(String from) {
        sessionFactory.openSessionWithTransaction();
        List<Person> persons = personDao.getAll(from);
        sessionFactory.closeSessionWithTransaction();
        return persons;
    }

    public List<Person> getByUsername(String username) {
        sessionFactory.openSessionWithTransaction();
        List<Person> person = personDao.getByUsername(username);
        sessionFactory.closeSessionWithTransaction();
        return person;
    }
}
