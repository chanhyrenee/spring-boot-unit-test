package com.example.exercise2.demo_exercise2.service;

import java.util.List;
import com.example.exercise2.demo_exercise2.entity.UserEntity;
import com.example.exercise2.demo_exercise2.model.User;

public interface UserService {

  List<User> getApiData();

  List<UserEntity> saveApiDataToDB(List<User> users);

  void deleteAllDb();

  List<UserEntity> findAllUsers();

  UserEntity saveUser(UserEntity userEntity);

  UserEntity deleteUser(Integer userId);

  UserEntity updateUser(Integer userId, UserEntity userEntity);

  UserEntity findbyId(Integer userId);

  UserEntity updateUserEmail(Integer userId, String email);

}
