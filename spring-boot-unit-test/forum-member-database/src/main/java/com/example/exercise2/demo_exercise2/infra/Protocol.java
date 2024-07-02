package com.example.exercise2.demo_exercise2.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Protocol {
  HTTPS("https"), //
  HTTP("http"), //
  SSH("ssh"),;

  private String protocal;

}
