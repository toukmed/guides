package com.spring.guides.services;

import com.spring.guides.dao.PersonDAO;
import com.spring.guides.entities.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {

  @Autowired
  private PersonDAO personDAO;

  public PersonService() {
  }

  public Person fetchPersonInfo(Integer id) {
    addPersons();
    return personDAO.getPersonById(id);
  }

  private void addPersons(){

  }


  public List<Person> fetchAllPersonsInfo() {
    addPersons();
    return personDAO.fetchAllPersons();
  }
}
