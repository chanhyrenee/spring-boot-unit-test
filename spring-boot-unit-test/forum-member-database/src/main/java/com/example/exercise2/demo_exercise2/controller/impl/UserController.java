package com.example.exercise2.demo_exercise2.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.exercise2.demo_exercise2.controller.UserOperation;
import com.example.exercise2.demo_exercise2.entity.UserEntity;
import com.example.exercise2.demo_exercise2.model.User;
import com.example.exercise2.demo_exercise2.service.UserService;

@RestController
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Override
  public List<User> getApiUsers() {
    return userService.getApiData();
  }

  @Override
  public List<UserEntity> saveApiUsers() {
    return userService.saveApiDataToDB(getApiUsers());
  }

  @Override
  public void deleteAllUsers() {
    userService.deleteAllDb();
  }

  @Override
  public List<UserEntity> findAllUsers() {
    return userService.findAllUsers();
  }

  @Override
  public UserEntity saveUser(@RequestBody UserEntity userEntity) {
    return userService.saveUser(userEntity);
  }

  @Override
  public UserEntity deleteUser(@RequestParam Integer userId) {
    return userService.deleteUser(userId);
  }

  @Override
  public UserEntity updateUser(@RequestParam Integer userId,
      @RequestBody UserEntity userEntity) {
    return userService.updateUser(userId, userEntity);
  }

  @Override
  public UserEntity updateUserEmail(Integer userId, String email) {
    return userService.updateUserEmail(userId, email);
  }
}
