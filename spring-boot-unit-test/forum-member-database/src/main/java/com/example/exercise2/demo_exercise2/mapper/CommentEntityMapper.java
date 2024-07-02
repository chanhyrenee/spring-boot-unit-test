package com.example.exercise2.demo_exercise2.mapper;

import org.springframework.stereotype.Component;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;
import com.example.exercise2.demo_exercise2.model.Comment;

@Component
public class CommentEntityMapper {

  public CommentEntity map(Comment comment) {
    return CommentEntity.builder().postId(comment.getPostId())
        .CommentId(comment.getCommentId()).commentName(comment.getCommentName())
        .email(comment.getEmail()).commentBody(comment.getCommentBody())
        .build();
  }
}
