package com.example.exercise2.demo_exercise2.service;

import java.util.List;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;
import com.example.exercise2.demo_exercise2.model.Comment;

public interface CommentService {

  List<Comment> getApiData();

  List<CommentEntity> saveApiDataToDb(List<Comment> comments);

  void deleteAllDb();

  List<CommentEntity> findAllComments();

  CommentEntity findbyId(Integer commentId);

  List<CommentEntity> findByPostId(Integer postId);

}
