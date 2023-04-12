package com.br.marks.api.config;

import com.br.marks.api.domain.User;
import com.br.marks.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

  @Autowired
  private UserRepository userRepository;

  @Bean
  public void startDB() {
    User u1 = new User(null, "Valdir", "valdir@gmail.com", "123");
    User u2 = new User(null, "André", "andre@gmail.com", "123");

    userRepository.saveAll(List.of(u1, u2));
  }

}
