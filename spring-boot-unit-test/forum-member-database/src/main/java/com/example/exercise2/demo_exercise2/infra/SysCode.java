package com.example.exercise2.demo_exercise2.infra;

import lombok.Getter;

@Getter
public enum SysCode {
  SUCCESS("1000", "Success."), //
  NOT_FOUND("1001", "No foundings from database."), //
  USERID_INVALID("1002", "User ID input invalid."), //
  RESTTEMPLATE_ERROR("1003", "RestTemplate Error - JsonPlaceHolder.");

  private String code;
  private String desc;

  private SysCode(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
