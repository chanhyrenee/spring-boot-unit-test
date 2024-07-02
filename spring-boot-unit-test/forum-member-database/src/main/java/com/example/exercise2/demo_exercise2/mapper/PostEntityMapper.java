package com.example.exercise2.demo_exercise2.mapper;

import org.springframework.stereotype.Component;
import com.example.exercise2.demo_exercise2.entity.PostEntity;
import com.example.exercise2.demo_exercise2.model.Post;

@Component
public class PostEntityMapper {

  public PostEntity map(Post post) {
    return PostEntity.builder().userId(post.getUserId())
        .postId(post.getPostId()).title(post.getTitle())
        .body(post.getPostBody()).build();
  }
}
