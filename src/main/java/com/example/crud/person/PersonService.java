package com.example.crud.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {


    @Autowired
    private final PersonRepository personRepo;
    
    public void saveOrUpdatePerson(Person person) {
        personRepo.save(person);
    }

    public List<Person> getPersona(){
        return personRepo.findAll();
    }

    public Optional<Person> getPersonaId(Integer id){
        return personRepo.findById(id);
    }

    public void delete(Integer id){
        personRepo.deleteById(id);
    }
}
