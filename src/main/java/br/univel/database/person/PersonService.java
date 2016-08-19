package br.univel.database.person;

import br.univel.database.DaoService;
import br.univel.model.person.Person;

import java.util.List;

/**
 * Created by felipefrizzo on 8/17/16.
 */
public class PersonService implements DaoService<Person, Long> {
    private static PersonDao personDao;

    public PersonService() {
        personDao = new PersonDao();
    }

    @Override
    public void save(Person entity) {
        personDao.openSessionWithTransaction();
        personDao.save(entity);
        personDao.closeSessionWithTransaction();
    }

    @Override
    public void update(Person entity) {
        personDao.openSessionWithTransaction();
        personDao.update(entity);
        personDao.closeSessionWithTransaction();
    }

    @Override
    public void delete(Person entity) {
        personDao.openSessionWithTransaction();
        personDao.delete(entity);
        personDao.closeSessionWithTransaction();
    }

    @Override
    public Person getById(Long id, Object object) {
        personDao.openSessionWithTransaction();
        Person person = personDao.getById(id, object);
        personDao.closeSessionWithTransaction();
        return person;
    }

    @Override
    public List<Person> getAll(String from) {
        personDao.openSessionWithTransaction();
        List<Person> persons = personDao.getAll(from);
        personDao.closeSessionWithTransaction();
        return persons;
    }
}
