package com.example.demo.service;

import com.example.demo.dao.PersonDao;

public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao){
        this.personDao = personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
}
