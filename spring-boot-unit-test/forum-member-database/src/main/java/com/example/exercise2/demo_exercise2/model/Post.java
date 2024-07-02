package com.example.exercise2.demo_exercise2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Post {
  private int userId;
  @JsonProperty(value = "id")
  private int postId;
  private String title;
  @JsonProperty(value = "body")
  private String postBody;
}
