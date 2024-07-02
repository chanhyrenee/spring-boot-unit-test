package com.example.exercise2.demo_exercise2.infra;

public class RestTemplateException extends BusinessRuntimeException {

  public RestTemplateException() {
    super(SysCode.RESTTEMPLATE_ERROR);
  }
}
