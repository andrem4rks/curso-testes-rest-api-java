package com.br.marks.api.service.impl;

import com.br.marks.api.domain.User;
import com.br.marks.api.domain.dto.UserDTO;
import com.br.marks.api.repository.UserRepository;
import com.br.marks.api.service.UserService;
import com.br.marks.api.service.exceptions.DataIntegratyViolationException;
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
    findByEmail(obj);
    return repository.save(mapper.map(obj, User.class));
  }

  @Override
  public User update(UserDTO obj) {
    findByEmail(obj);
    return repository.save(mapper.map(obj, User.class));
  }

  @Override
  public void delete(Integer id) {
    findById(id);
    repository.deleteById(id);
  }

  private void findByEmail(UserDTO obj) {
    Optional<User> user = repository.findByEmail(obj.getEmail());
    if(user.isPresent() && !user.get().getId().equals(obj.getId())) {
      throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
    }
  }
}
