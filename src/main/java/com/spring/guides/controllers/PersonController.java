package com.spring.guides.controllers;

import com.spring.guides.entities.Person;
import com.spring.guides.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

  @Autowired
  private PersonService personService;

  public PersonController(){
  }

  @GetMapping("/fetchInfo")
  public Person fetchPersonInfo(@RequestParam(name = "id") Integer id){
    return personService.fetchPersonInfo(id);
  }


}
