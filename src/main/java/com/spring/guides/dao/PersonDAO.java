package com.spring.guides.dao;

import com.spring.guides.entities.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {


  private final static String INSERT_PERSON = "INSERT INTO persons(id, first_name, last_name, phone_number) VALUES (?, ?, ?, ?);";
  private final static String GET_PERSON_BY_ID = "SELECT * FROM persons where id = ?";
  private final static String GET_ALL_PERSONS = "SELECT * FROM persons";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public PersonDAO() {
  }

  public void addPerson(Person person) {
    jdbcTemplate.update(INSERT_PERSON, new Object[]{person.getId(), person.getFirstName(), person.getLastName(), person.getPhoneNumber()});
  }

  public Person getPersonById(Integer id){
    return jdbcTemplate.queryForObject(GET_PERSON_BY_ID, new Object[]{id}, new PersonRowMapper());
  }

  public List<Person> fetchAllPersons() {
    List<Person> persons = new ArrayList<>();
    List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_ALL_PERSONS);

    for (Map row: rows) {
      Person person = new Person();
      person.setId(((Integer) row.get("id")).intValue());
      person.setFirstName((String) row.get("first_name"));
      person.setLastName((String) row.get("last_name"));
      person.setPhoneNumber((String) row.get("phone_number"));
      persons.add(person);
    }
    return persons;
  }
}
