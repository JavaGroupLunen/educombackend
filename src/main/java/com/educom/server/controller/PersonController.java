package com.educom.server.controller;

import com.educom.server.entity.Person;

import com.educom.server.services.PersonService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String saveperson(@RequestBody JSONObject requestparam) {
        Person person = new Person(requestparam.get("firstName").toString(), requestparam.get("lastName").toString(), requestparam.get("emailId").toString());
        return personService.savePersonDetails(person);
    }

    @RequestMapping(value = "/personlist", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> showpersonList() {
        List<Person> personlist = personService.getAllperson();
        return new ResponseEntity<List<Person>>(personlist, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbyId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getperson(@PathVariable("id") Long id) {
        Person person = personService.getPerson(id);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByName/{firstname}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> personFindByName(@PathVariable("firstname") String firstName) {
        List<Person> personList = personService.findByName(firstName);
        return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByLastName/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> personFindByLastName(@PathVariable("lastName") String lastName) {
        List<Person> personList = personService.findByLastName(lastName);
        return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByEmailId/{emailId}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> personFindByEmailId(@PathVariable("emailId") String emailId) {
        List<Person> personList = personService.findByEmailId(emailId);
        return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
    }


    @RequestMapping(value = "/deletebyId/{id}", method = RequestMethod.DELETE)
    public String  deleteperson(@PathVariable Long id) {
        return personService.deletePerson(id);

    }
    //TODO: Es muss repariert werden. funksoniert nicht richtigt
    @RequestMapping(value = "/updateperson/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updateperson(@PathVariable("id") Long id,@RequestBody Person person) {
        personService.updatePerson(id,person);
        return new ResponseEntity<Person>(person, HttpStatus.OK);

    }
}
