package com.javatpoint.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class UserResource {

  @Autowired
  private UserDaoService service;

  @GetMapping("/users")
  public List<User> retriveAllUser() {
    return service.findAll();
  }

  @GetMapping("/users/{id}")
  public User retriveUser(@PathVariable Integer id) {
    return service.findOne(id);
  }

  @PostMapping("/users")
  public void createUser(@RequestBody User user) {
    User savedUser = service.save(user);
  }

}
