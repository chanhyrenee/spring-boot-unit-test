package com.example.exercise2.demo_exercise2.service;

import java.util.List;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;

public interface ForumService {

  List<AllDataByUserDto> getAllDataByUser();

  List<CommentEntity> getAllCommentByUser(int userId);
}
