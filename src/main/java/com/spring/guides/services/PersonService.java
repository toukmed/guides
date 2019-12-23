package com.spring.guides.services;

import com.spring.guides.dao.PersonDAO;
import com.spring.guides.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {

  @Autowired
  private PersonDAO personDAO;
  {
    personDAO.addPerson(new Person(1, "touk", "med", "0123456789"));
    personDAO.addPerson(new Person(2, "touk2", "med2", "0987654321"));
    personDAO.addPerson(new Person(3, "touk3", "med3", "0147852369"));
  }

  public PersonService() {
  }

  public Person fetchPersonInfo(Integer id) {
    return personDAO.getPersonById(id);
  }


}
