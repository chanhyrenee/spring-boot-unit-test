package com.example.exercise2.demo_exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.exercise2.demo_exercise2.entity.PostEntity;
import com.example.exercise2.demo_exercise2.model.Post;

public interface PostOperation {
  
  @GetMapping(value = "getApiPosts")
  List<Post> getApiPosts();

  @PostMapping(value = "saveApiPosts")
  List<PostEntity> saveApiPosts();

  @DeleteMapping(value = "deleteAllPosts")
  void deleteAllPosts();
}
