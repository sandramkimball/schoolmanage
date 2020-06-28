package com.example.themanager.dao;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.example.themanager.models.Person;

@Respository('postgres')
public class PersonDataAccessService implements PersonDao {
    @Override
    public int insertPerson(UUID id, Person person){
        DB.add( new Person(id, person.getName() ));
        return 1
    }

    @Override
    public List<Person> selectAllPeople() {
        return List.of(new Person(UUID.randomUUID(), name: 'FAKE POSTGRESS DB'));
    }

    @Override
    public Optional<Person> selectPersonById(UUID id){
        return DB.stream()
                .filter( person -> person.getId().equals(id) )
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> doesPersonExist = selectPersonById(id);
        if (doesPersonExist.isEmpty()){
            return 0
        }
        DB.remove(doesPersonExist.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(p -> {
                    int updatedPerson = DB.indexOf(person);
                    if (updatedPerson) {
                        DB.set(updatedPerson, newPerson(id, update.getName()));
                        return 1
                    }
                    return 0
                });
                .orElse(other: 0)
    }

}