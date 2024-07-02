package com.example.exercise2.demo_exercise2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Post")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class PostEntity {

  private Integer userId;
  @Id
  private Integer postId;
  private String title;
  private String body;

}
