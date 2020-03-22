package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);   //given an id
    default int insertPerson(Person person){      //without an id
        UUID id=UUID.randomUUID();
        return insertPerson(id,person);
    }
    List<Person> selectAllPeople();
    Optional<Person> selectPersonById(UUID id);
    int deletePersonById(UUID id);

    int updatePersonById(UUID id,Person person);


}
