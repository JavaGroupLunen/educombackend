package com.educom.server.serviceImpl;

import com.educom.server.dao.PersonDao;
import com.educom.server.entity.Person;
import com.educom.server.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonDao personDao;

    @Override
    public List<Person> getAllperson() {
        return personDao.getAllperson();
    }

    @Override
    public String savePersonDetails(Person person) {

        return personDao.savePersonDetails(person);
    }

    @Override
    public Person getPerson(Long id) {
        return personDao.getPerson(id);
    }

    @Override
    public String deletePerson(Long id) {
        personDao.deletePerson(id);
        return null;
    }

    @Override
    public List<Person> findByName(String firstName) {
        return personDao.findByName(firstName);
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return personDao.findByLastName(lastName);
    }

    @Override
    public List<Person> findByEmailId(String emailId) {
        return personDao.findByEmailId(emailId);
    }

    @Override
    public String updatePerson(Long id,Person Person) {
        return personDao.updatePerson(id,Person);
    }


}
