package com.example.exercise2.demo_exercise2.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.exercise2.demo_exercise2.controller.CommentOperation;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;
import com.example.exercise2.demo_exercise2.model.Comment;
import com.example.exercise2.demo_exercise2.service.CommentService;

@RestController
public class CommentController implements CommentOperation{
  
  @Autowired
  private CommentService commentService;

  @Override
  public List<Comment> getApiComments() {
    return commentService.getApiData();
  }

  @Override
  public List<CommentEntity> saveApiComments() {
    return commentService.saveApiDataToDb(getApiComments());
  }

  @Override
  public void deleteAllComments() {
    commentService.deleteAllDb();
  }

}
