package com.example.exercise2.demo_exercise2.infra;

public class UserIdInvalidException extends BusinessRuntimeException {

  public UserIdInvalidException() {
    super(SysCode.USERID_INVALID);
  }
}
