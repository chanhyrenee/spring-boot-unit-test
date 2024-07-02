package com.example.exercise2.demo_exercise2.infra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiResp<Void> notFoundExceptionHandler(NotFoundException e) {
    return ApiResp.<Void>builder().fail(SysCode.NOT_FOUND).resultDTO(null)
        .build();
  }

  @ExceptionHandler(UserIdInvalidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiResp<Void> userIdInvalidExceptionHandler(UserIdInvalidException e) {
    return ApiResp.<Void>builder().fail(SysCode.USERID_INVALID).resultDTO(null)
        .build();
  }

  @ExceptionHandler(RestTemplateException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiResp<Void> RestTemplateExceptionHandler(RestTemplateException e) {
    return ApiResp.<Void>builder().fail(SysCode.RESTTEMPLATE_ERROR)
        .resultDTO(null).build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiResp<Void> ExceptionHandler(Exception e) {
    return ApiResp.<Void>builder().build();
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiResp<Void> RuntimeExceptionHandler(RuntimeException e) {
    return ApiResp.<Void>builder().build();
  }
}
