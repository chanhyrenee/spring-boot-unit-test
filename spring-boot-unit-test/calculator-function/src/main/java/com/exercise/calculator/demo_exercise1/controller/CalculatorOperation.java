package com.exercise.calculator.demo_exercise1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.exercise.calculator.demo_exercise1.dto.ResultDTO;
import com.exercise.calculator.demo_exercise1.infra.ApiResp;

public interface CalculatorOperation {

  // http://localhost:8091/api/v1/calculator?x=2.2&y=3&z=add
  @GetMapping(value = "calculator")
  ResponseEntity<ApiResp<ResultDTO>> calculator(@RequestParam String x,
      @RequestParam String y, @RequestParam String z);

  // JSON input testcase: { "operation": "add", "x": "123", "y": "456" }
  @GetMapping(value = "calculator/jsoninput")
  ResponseEntity<ApiResp<ResultDTO>> calculatorJsonInput(
      @RequestBody ResultDTO jsoninput);
}
