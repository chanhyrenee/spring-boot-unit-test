package com.example.exercise2.demo_exercise2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Comment {
  private int postId;
  @JsonProperty(value = "id")
  private int commentId;
  @JsonProperty(value = "name")
  private String commentName;
  private String email;
  @JsonProperty(value = "body")
  private String commentBody;
}
