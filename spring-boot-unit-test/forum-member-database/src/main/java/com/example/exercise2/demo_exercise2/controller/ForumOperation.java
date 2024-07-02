package com.example.exercise2.demo_exercise2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.exercise2.demo_exercise2.dto.AllCommentByUserDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto;

public interface ForumOperation {

  @GetMapping(value = "getalldatabyuser")
  List<AllDataByUserDto> getAllDataByUser();

  @GetMapping(value = "getallcommentbyuser")
  AllCommentByUserDto getAllCommentByUser(@RequestParam String id);
  
}
