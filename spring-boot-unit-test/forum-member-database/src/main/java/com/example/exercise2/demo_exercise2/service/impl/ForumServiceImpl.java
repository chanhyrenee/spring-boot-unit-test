package com.example.exercise2.demo_exercise2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.PostDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.PostDto.CommentDto;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;
import com.example.exercise2.demo_exercise2.entity.PostEntity;
import com.example.exercise2.demo_exercise2.entity.UserEntity;
import com.example.exercise2.demo_exercise2.mapper.AllDataByUserDtoMapper;
import com.example.exercise2.demo_exercise2.service.CommentService;
import com.example.exercise2.demo_exercise2.service.ForumService;
import com.example.exercise2.demo_exercise2.service.PostService;
import com.example.exercise2.demo_exercise2.service.UserService;

@Service
public class ForumServiceImpl implements ForumService {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private CommentService commentService;

  @Autowired
  private AllDataByUserDtoMapper allDataByUserDtoMapper;

  public List<AllDataByUserDto> getAllDataByUser() {
    List<AllDataByUserDto> list1 = new ArrayList<>();
    for (UserEntity userEntity : userService.findAllUsers()) {
      List<PostDto> list2 = new ArrayList<>();
      for (PostEntity postEntity : postService.findByUserId(userEntity.getUserId())) {
        List<CommentDto> list3 = new ArrayList<>();
        for (CommentEntity commentEntity : commentService.findByPostId(postEntity.getPostId())) {
          list3.add(allDataByUserDtoMapper.mapToCommentDto(commentEntity));
        }
        list2.add(allDataByUserDtoMapper.mapToPostDto(postEntity, list3));
      }
      list1.add(allDataByUserDtoMapper.map(userEntity, list2));
    }
    return list1;
  }

  @Override
  public List<CommentEntity> getAllCommentByUser(int userId) {
    List<CommentEntity> allCommentsOfUser = new ArrayList<>();
    postService.findAllPosts().stream()
        .filter(x -> x.getUserId().equals(userId)).forEach(postEntity -> {
          allCommentsOfUser.addAll(commentService.findAllComments().stream()
              .filter(x -> x.getPostId() == postEntity.getPostId())
              .collect(Collectors.toList()));
        });
    return allCommentsOfUser;
  }
}
