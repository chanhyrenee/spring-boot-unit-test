package com.example.exercise2.demo_exercise2.service;

import java.util.List;
import com.example.exercise2.demo_exercise2.entity.PostEntity;
import com.example.exercise2.demo_exercise2.model.Post;

public interface PostService {

  List<Post> getApiData();

  List<PostEntity> saveApiDataToDb(List<Post> posts);

  void deleteAllDb();

  List<PostEntity> findAllPosts();

  PostEntity findbyId(Integer postId);

  List<PostEntity> findByUserId(Integer userId);

}
