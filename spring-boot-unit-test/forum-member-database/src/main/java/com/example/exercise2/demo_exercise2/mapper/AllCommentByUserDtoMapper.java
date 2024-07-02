package com.example.exercise2.demo_exercise2.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.exercise2.demo_exercise2.dto.AllCommentByUserDto;
import com.example.exercise2.demo_exercise2.dto.AllCommentByUserDto.CommentsOfUser;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;
import com.example.exercise2.demo_exercise2.entity.UserEntity;
import com.example.exercise2.demo_exercise2.service.UserService;

@Component
public class AllCommentByUserDtoMapper {

  @Autowired
  private UserService userService;

  public AllCommentByUserDto map(int userId,
      List<CommentEntity> commentEntities) {

    UserEntity userEntity = userService.findbyId(userId);

    List<CommentsOfUser> commentsOfUser = commentEntities.stream()
        .map(commentEntity -> CommentsOfUser.builder()//
            .name(commentEntity.getCommentName())//
            .email(commentEntity.getEmail())//
            .body(commentEntity.getCommentBody()).build())
        .collect(Collectors.toList());

    return AllCommentByUserDto.builder().id(userEntity.getUserId()).username(userEntity.getUsername())
        .commentOfUserList(commentsOfUser).build();
  }
}
