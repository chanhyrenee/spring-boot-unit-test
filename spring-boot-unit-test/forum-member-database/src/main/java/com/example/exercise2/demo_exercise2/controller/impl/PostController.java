package com.example.exercise2.demo_exercise2.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.exercise2.demo_exercise2.controller.PostOperation;
import com.example.exercise2.demo_exercise2.entity.PostEntity;
import com.example.exercise2.demo_exercise2.model.Post;
import com.example.exercise2.demo_exercise2.service.PostService;

@RestController
public class PostController implements PostOperation {

  @Autowired
  private PostService postService;

  @Override
  public List<Post> getApiPosts() {
    return postService.getApiData();
  }

  @Override
  public List<PostEntity> saveApiPosts() {
    return postService.saveApiDataToDb(getApiPosts());
  }

  @Override
  public void deleteAllPosts() {
    postService.deleteAllDb();
  }
}
