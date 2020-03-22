package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")  // map with postman
@RestController //endpoints
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person){  //post RequestBody with model in person
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){    // get request
        return personService.getAllPeople();  //order:DAO-->Service-->controller
    }
    @GetMapping(path="{id}")
    public Person getPersonById(@PathVariable("id") UUID id){  //get person by id in postman using @pathv
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {  //get person by id in postman using @pathv
        personService.getPersonById(id);
    }
    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id")UUID id,@Valid @NotNull @RequestBody Person personToUpdate){
        personService.updatePerson(id,personToUpdate);           //REST API
    }

}
