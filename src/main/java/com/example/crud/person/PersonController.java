package com.example.crud.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
  
    @Autowired
    private final PersonService personService;


    //Método POST - Update and Save
    @PostMapping
    public void saveUpdate(@RequestBody Person person){
        personService.saveOrUpdatePerson(person);
    }
    
    //Método GET
    @GetMapping
    public ResponseEntity<List<Person>> getPersona()
    {
        return new ResponseEntity<List<Person>>(personService.getPersona(), HttpStatus.OK);
    }

    //Método GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getIdPerson(@PathVariable("id") Integer id){
        return new ResponseEntity<Optional<Person>>(personService.getPersonaId(id), HttpStatus.OK);
    }


    //Método DELETE
    @DeleteMapping("/{id}")
    public void saveUpdate(@PathVariable("id") Integer id){
        personService.delete(id);
    }   
}
