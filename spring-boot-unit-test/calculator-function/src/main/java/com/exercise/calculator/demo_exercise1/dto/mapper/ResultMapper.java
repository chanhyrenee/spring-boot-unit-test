package com.exercise.calculator.demo_exercise1.dto.mapper;

import com.exercise.calculator.demo_exercise1.dto.ResultDTO;

public class ResultMapper {
  public static ResultDTO mapToResultDTO(String x, String y, String z,
      String result) {
    return new ResultDTO(x, y, z, result);
  }
}
