package com.example.themanager.dao;
import com.example.themanager.model.Person;
import java.util.UUID;

// Interface defining operations allowed, contracted for what you'll implement
// Use injections to switch between implementations

// DAO = Data Access Object
// A structural pattern to isolate apps/business layer from 
// persistence layer (relational db) using abstract api.


public interface PersonDao {
    // mock db list
    int insertPerson(UUID id, Person person)

    // generate UUID, sets up data to be inserted to table
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person)
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id)

    int deletePersonById(UUID id)

    int updatePersonById(UUID id, Person person)
}