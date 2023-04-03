package com.br.marks.api.service;

import com.br.marks.api.domain.User;
import com.br.marks.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
  User findById(Integer id);
  List<User> findAll();
  User create(UserDTO obj);
  User update(UserDTO obj);
}
