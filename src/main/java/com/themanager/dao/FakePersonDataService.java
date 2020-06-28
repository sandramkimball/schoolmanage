package com.example.themanager.dao;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.example.themanager.models.Person;

// tell Spring to instantiated this class as beans to inject to other classes
// 'fakeDao' to be replaced by whatever db usd (ex. mongo)
@Repository('fakeDao')

public class FakePersonDataService implements PersonDao {
    private static List<Person> DV = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person){
        DB.add( new Person(id, person.getName() ));
        return 1
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id){
        return DB.stream()
                .filter( person -> person.getId().equals(id) )
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}