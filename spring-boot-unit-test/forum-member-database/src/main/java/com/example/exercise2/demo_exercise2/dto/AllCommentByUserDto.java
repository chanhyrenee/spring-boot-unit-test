package com.example.exercise2.demo_exercise2.dto;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class AllCommentByUserDto {
  private Integer id;
  private String username;
  private List<CommentsOfUser> commentOfUserList;

  @Builder
  @Getter
  @EqualsAndHashCode
  public static class CommentsOfUser {
    private String name;
    private String email;
    private String body;
  }
}
