package com.spring.guides.dao;

import com.spring.guides.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

  private final static String CREATE_PERSON_TABLE = "CREATE TABLE persons(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255), phone_number VARCHAR(255)";
  private final static String INSERT_PERSON = "INSERT INTO persons(id, first_name, last_name, phone_number)";
  private final static String GET_PERSON_BY_ID = "SELECT p FROM persons where id = ?";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public PersonDAO() {
    createPersonTable();
  }

  public void addPerson(Person person) {
    jdbcTemplate.execute(INSERT_PERSON);
  }

  public Person getPersonById(Integer id) {
    return jdbcTemplate.query(GET_PERSON_BY_ID, new Object[]{id}, (ResultSetExtractor<Person>) resultSet -> new Person(resultSet.getInt("id"),
        resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("phone_number")));
  }

  public Person getPersonById2(Integer id){
    return jdbcTemplate.queryForObject(GET_PERSON_BY_ID, new Object[]{id}, new PersonRowMapper());
  }

  private void createPersonTable() {
    jdbcTemplate.execute(CREATE_PERSON_TABLE);
  }

}
