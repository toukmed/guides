package com.spring.guides.dao;

import com.spring.guides.entities.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person> {

  @Override
  public Person mapRow(ResultSet resultSet, int i) throws SQLException {

    Person person = new Person();
    person.setId(resultSet.getInt("id"));
    person.setFirstName(resultSet.getString("first_name"));
    person.setLastName(resultSet.getString("last_name"));
    person.setPhoneNumber(resultSet.getString("phone_number"));
    return person;
  }
}
