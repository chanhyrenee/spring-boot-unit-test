package com.example.exercise2.demo_exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.exercise2.demo_exercise2.entity.UserEntity;
import com.example.exercise2.demo_exercise2.model.User;

public interface UserOperation {

  @GetMapping(value = "getApiUsers")
  List<User> getApiUsers();

  @PostMapping(value = "saveApiUsers")
  List<UserEntity> saveApiUsers();

  @DeleteMapping(value = "deleteAllUsers")
  void deleteAllUsers();

  @GetMapping(value = "/user")
  List<UserEntity> findAllUsers();

  @PostMapping(value = "/user")
  UserEntity saveUser(@RequestBody UserEntity userEntity);

  @DeleteMapping(value = "/user")
  UserEntity deleteUser (@RequestParam Integer userId);

  @PutMapping(value = "/user")
  UserEntity updateUser(@RequestParam Integer userId, @RequestBody UserEntity userEntity);

  @PatchMapping(value = "/user")
  UserEntity updateUserEmail(@RequestParam Integer userId, @RequestParam String email);

}
