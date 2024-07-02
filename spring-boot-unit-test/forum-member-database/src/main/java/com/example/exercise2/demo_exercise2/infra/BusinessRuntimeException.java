package com.example.exercise2.demo_exercise2.infra;

import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException {
  private String code;

  public BusinessRuntimeException(SysCode code) {
    super(code.getDesc());
    this.code = code.getCode();
  }
}
