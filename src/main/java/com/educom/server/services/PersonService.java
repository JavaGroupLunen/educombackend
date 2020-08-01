package com.educom.server.services;

import com.educom.server.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllperson();
    String savePersonDetails(Person person);
    Person getPerson(Long id);
    String deletePerson(Long id);
    List<Person> findByName(String firstName);
    List<Person> findByLastName(String lastName);
    List<Person> findByEmailId(String emailId);
    String updatePerson(Long id,Person person);
}
