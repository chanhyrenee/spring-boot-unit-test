package com.example.exercise2.demo_exercise2.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.example.exercise2.demo_exercise2.entity.UserEntity;
import com.example.exercise2.demo_exercise2.infra.Protocol;
import com.example.exercise2.demo_exercise2.infra.RestTemplateException;
import com.example.exercise2.demo_exercise2.infra.UrlBuilder;
import com.example.exercise2.demo_exercise2.infra.NotFoundException;
import com.example.exercise2.demo_exercise2.mapper.UserEntityMapper;
import com.example.exercise2.demo_exercise2.model.User;
import com.example.exercise2.demo_exercise2.repository.UserRepository;
import com.example.exercise2.demo_exercise2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserEntityMapper userEntityMapper;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String domain;

  @Value(value = "${api.jsonplaceholder.endpoint.users}")
  private String endpoint;

  @Override
  public List<User> getApiData() {
    try {
      User[] users = restTemplate.getForObject(
          UrlBuilder.get(Protocol.HTTP, domain, endpoint), User[].class);
      return Arrays.asList(users);
    } catch (RestClientException e) {
      throw new RestTemplateException();
    }
  }

  @Override
  public List<UserEntity> saveApiDataToDB(List<User> users) {
    List<UserEntity> userEntities = users.stream()
        .map(x -> userEntityMapper.map(x)).collect(Collectors.toList());
    return userRepository.saveAll(userEntities);
  }

  @Override
  public void deleteAllDb() {
    userRepository.deleteAll();
  }

  @Override
  public List<UserEntity> findAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public UserEntity saveUser(UserEntity userEntity) {
    return userRepository.save(userEntity);
  }

  @Override
  public UserEntity deleteUser(Integer userId) {
    UserEntity userEntity = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException());
    userRepository.deleteById(userId);
    return userEntity;
  }

  @Override
  public UserEntity updateUser(Integer userId, UserEntity userEntity) {
    UserEntity existingUser = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException());
    // existingUser.setEmail(userEntity.getEmail());
    return userRepository.save(existingUser);
  }

  @Override
  public UserEntity findbyId(Integer userId) {
    return userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException());
  }
  
  @Override
  public UserEntity updateUserEmail(Integer userId, String email) {
    if (userRepository.updateEmailByUserID(userId, email))
      return userRepository.findById(userId).get();
    throw new RuntimeException();
  }

}
