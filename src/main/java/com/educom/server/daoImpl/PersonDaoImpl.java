package com.educom.server.daoImpl;

import com.educom.server.dao.PersonDao;
import com.educom.server.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Component
@Transactional
@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Person> getAllperson() {

        List<Person> PersonList = entityManager.createQuery("from Person").getResultList();

        return PersonList;
    }

    @Override
    public String savePersonDetails(Person Person) {

        entityManager.merge(Person);

        return "success";
    }

    @Override
    public String updatePerson(Long id, Person person) {
        Person updatePerson = getPerson(id);
        updatePerson.setEmail(person.getEmail());
        updatePerson.setFirstName(person.getFirstName());
        updatePerson.setLastName(person.getLastName());
        System.out.println(person.getId());
        entityManager.merge(updatePerson);
        return "success";
    }

    @Override
    public Person getPerson(Long id) {

        Person obj = entityManager.find(Person.class, id);
        return obj;
    }

    @Override
    public String deletePerson(Long id) {
        Person person = getPerson(id);
        entityManager.remove(person);
        return "removed";
    }

    @Override
    public List<Person> findByName(String firstName) {
        return entityManager.createQuery(
                "from Person where firstName LIKE CONCAT('%', :firstName,'%')")
                .setParameter("firstName", firstName)
                .getResultList();
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return entityManager.createQuery(
                "from Person where lastName  LIKE CONCAT('%', :lastName,'%')")
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<Person> findByEmailId(String email) {
        return entityManager.createQuery(
                "from Person where email LIKE CONCAT('%',:email,'%')")
                .setParameter("email", email)
                .getResultList();
    }
}
