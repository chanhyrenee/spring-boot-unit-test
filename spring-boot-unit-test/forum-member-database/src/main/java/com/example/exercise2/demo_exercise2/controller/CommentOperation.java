package com.example.exercise2.demo_exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;
import com.example.exercise2.demo_exercise2.model.Comment;

public interface CommentOperation {

  @GetMapping(value = "getApiComments")
  List<Comment> getApiComments();

  @PostMapping(value = "saveApiComments")
  List<CommentEntity> saveApiComments();

  @DeleteMapping(value = "deleteAllComments")
  void deleteAllComments();
}
