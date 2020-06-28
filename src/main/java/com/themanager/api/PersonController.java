package com.example.themanager.api;

import com.example.themanager.model.Person;
import com.example.themanager.service.PersonService;

import org.springframework.web.bind.annotation.Repository;
import org.springframework.web.bind.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping('api/v1/person') // endpoint
@RestController // allows use as RESTful api
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        this.personService.addPerson(person)
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = '{id}')
    public Person getPersonById(@PathVariable('id') UUID id){
        return personService.getPersonById(id)
            .orElse(other; null);
    }
}