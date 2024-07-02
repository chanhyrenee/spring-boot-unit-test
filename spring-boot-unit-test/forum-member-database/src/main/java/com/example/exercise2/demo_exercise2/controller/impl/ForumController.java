package com.example.exercise2.demo_exercise2.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.exercise2.demo_exercise2.controller.ForumOperation;
import com.example.exercise2.demo_exercise2.dto.AllCommentByUserDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto;
import com.example.exercise2.demo_exercise2.infra.UserIdInvalidException;
import com.example.exercise2.demo_exercise2.mapper.AllCommentByUserDtoMapper;
import com.example.exercise2.demo_exercise2.service.ForumService;

@RestController
public class ForumController implements ForumOperation {

  @Autowired
  private ForumService forumService;

  @Autowired
  AllCommentByUserDtoMapper allCommentByUserDtoMapper;

  @Override
  public List<AllDataByUserDto> getAllDataByUser() {
    return forumService.getAllDataByUser();
  }

  @Override
  public AllCommentByUserDto getAllCommentByUser(String id) {
    try {
      int userId = Integer.parseInt(id);
      return allCommentByUserDtoMapper.map(userId,
          forumService.getAllCommentByUser(userId));
    } catch (NumberFormatException e) {
      throw new UserIdInvalidException();
    }
  }

}
