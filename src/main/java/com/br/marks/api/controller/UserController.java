package com.br.marks.api.controller;

import com.br.marks.api.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  @RequestMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Integer id) {
    return ResponseEntity.ok().body(new User(1, "Valdir", "val@mail.com", "123"));
  }
}
