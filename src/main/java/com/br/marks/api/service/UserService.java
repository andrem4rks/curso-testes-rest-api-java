package com.br.marks.api.service;

import com.br.marks.api.domain.User;

import java.util.List;

public interface UserService {
  User findById(Integer id);
  List<User> findAll();
}
