package com.exercise.calculator.demo_exercise1.infra;

import lombok.Getter;

@Getter
public enum SysCode {
  SUCCESS("1000", "Success."), //
  INVALID_INPUT_OPR("1001", "URL operator input invalid."), //
  INVALID_INPUT_NUM("1002", "URL number input invalid."), //
  INVALID_NUM_DIV("1003", "Input number is not accepted for division.");

  private String code;
  private String desc;

  private SysCode(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
