package com.example.themanager.service;

import com.example.themanager.dao.PersonDao;
import com.example.themanager.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class PersonService {
    // get interface, not class
    private final PersonDao personDao;

    @Autowired // Spring injection - switch Qualifier to whatever
    public PersonService(@Qualifier('postgres') PersonDao personDao){
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.getAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public interface deletePerson(UUID id){
        return personDao.deletePerson(id);
    }

    public int updatePerson(UUID id, Person person){
        return personDao.updatePerson(id, person);
    }
}