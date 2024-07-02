package com.exercise.calculator.demo_exercise1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResultDTO {
  private String x;
  private String y;
  private String operation;
  private String result;
}
