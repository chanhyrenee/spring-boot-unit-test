package com.example.exercise2.demo_exercise2.infra;

public class NotFoundException extends BusinessRuntimeException {

  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }
}
