package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;
    @Autowired       //bind together, name is fakeDao
    public PersonService (@Qualifier("postgres") PersonDao personDao) {  //constructioon
        this.personDao=personDao;
    }

    public int addPerson(Person person){  //linke to controller
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();

    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);  //next: controller!!!
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id,Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }
}
