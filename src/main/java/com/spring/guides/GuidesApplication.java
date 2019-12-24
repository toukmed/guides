package com.spring.guides;

import com.spring.guides.entities.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;

@SpringBootApplication
@EnableScheduling
public class GuidesApplication implements CommandLineRunner {

  private static final String CREATE_PERSON_TABLE = "CREATE TABLE persons(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255), phone_number VARCHAR(255));";
  private static final String INSERT_PERSON = "INSERT INTO persons(id, first_name, last_name, phone_number) VALUES (?, ?, ?, ?);";
  private static final String DROP_TABLE = "DROP TABLE persons IF EXISTS;";

  private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

  @Autowired
  JdbcTemplate jdbcTemplate;

  public static void main(String[] args) {
    SpringApplication.run(GuidesApplication.class, args);
  }


  @Override
  public void run(String... args) throws Exception {
    jdbcTemplate.execute(DROP_TABLE);
    jdbcTemplate.execute(CREATE_PERSON_TABLE);
    jdbcTemplate.update(INSERT_PERSON, new Object[]{1, "touk", "med", "0123456789"});
    jdbcTemplate.update(INSERT_PERSON, new Object[]{2, "touk2", "med2", "0987654321"});
    jdbcTemplate.update(INSERT_PERSON, new Object[]{3, "touk3", "med3", "0147852369"});
  }

  @Scheduled(fixedRate = 5000)
  public void reportServerSanity(){
    logger.info("----------------------The server is running as expected----------------------------");
  }

}
