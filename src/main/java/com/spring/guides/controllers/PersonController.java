package com.spring.guides.controllers;

import com.spring.guides.entities.Person;
import com.spring.guides.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

  @Autowired
  private PersonService personService;

  public PersonController(){
  }

  @GetMapping("/fetchInfo/{id}")
  public Person fetchPersonInfo(@PathVariable Integer id){
    return personService.fetchPersonInfo(id);
  }

  @GetMapping("/fetchInfo")
  public List<Person> fetchPersonInfo(){
    return personService.fetchAllPersonsInfo();
  }


}
