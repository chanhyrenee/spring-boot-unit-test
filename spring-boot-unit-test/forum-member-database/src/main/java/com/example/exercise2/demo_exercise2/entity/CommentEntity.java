package com.example.exercise2.demo_exercise2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Comment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CommentEntity {

  @Id
  private Integer postId;
  private Integer CommentId;
  private String commentName;
  private String email;
  private String commentBody;
}
