package com.br.marks.api.service.impl;

import com.br.marks.api.domain.User;
import com.br.marks.api.domain.dto.UserDTO;
import com.br.marks.api.repository.UserRepository;
import com.br.marks.api.service.UserService;
import com.br.marks.api.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private ModelMapper mapper;

  @Override
  public User findById(Integer id){
    Optional<User> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

  @Override
  public List<User> findAll() {
    return repository.findAll();
  }

  @Override
  public User create(UserDTO obj) {
    return repository.save(mapper.map(obj, User.class));
  }
}
