package com.lowes.embedded.controller;

import com.lowes.embedded.model.User;
import com.lowes.embedded.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class UserController {

  private UserRepository repository;

  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @PostConstruct
  public void loadData() {
    List<User> users = new ArrayList<>();

    users.add(new User("01", "Virat Kohli", "test@123", "virat@bcci.com"));
    users.add(new User("02", "Dhoni", "test@123", "dhoni@bcci.com"));
    users.add(new User("03", "Jadeja", "test@123", "jadeja@bcci.com"));
    users.add(new User("04", "Rohit Sharma", "test@123", "rohit@bcci.com"));
    users.add(new User("05", "Hardick Pandya", "test@123", "pandya@bcci.com"));
    users.add(new User("06", "Rishabh Pant", "test@123", "pant@bcci.com"));
    repository.saveAll(users);
    log.info("loaded embeded db");
    log.info(repository.findAll().toString());

  }


  @GetMapping("/hi")
  public User getByName() {
    return this.repository.findByName("Dhoni");
  }


}
