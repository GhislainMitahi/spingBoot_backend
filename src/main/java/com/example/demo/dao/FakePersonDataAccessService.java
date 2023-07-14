package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.*;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{
    private static List<Person> DB = new ArrayList<>();
        @Override
        public int insertPerson(UUID id, Person person) {
            DB.add(new Person(id, person.getName()));
            return 1;
    }
    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person>personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person Person) {
            return selectPersonById(id)
                    .map(person->{
                        int indexOfPersonToDelete = DB.indexOf(person);
                        if(indexOfPersonToDelete >= 0){
                            DB.set(indexOfPersonToDelete, person);
                            return 1;
                        }
                        return 0;
                    })
                    .orElse(0);
    }
}
