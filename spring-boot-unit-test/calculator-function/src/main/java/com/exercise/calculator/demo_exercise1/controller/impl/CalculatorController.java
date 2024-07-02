package com.exercise.calculator.demo_exercise1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.calculator.demo_exercise1.controller.CalculatorOperation;
import com.exercise.calculator.demo_exercise1.dto.ResultDTO;
import com.exercise.calculator.demo_exercise1.dto.mapper.ResultMapper;
import com.exercise.calculator.demo_exercise1.infra.ApiResp;
import com.exercise.calculator.demo_exercise1.service.CalculateService;

@RestController
@RequestMapping("/api/v1")
public class CalculatorController implements CalculatorOperation {

  @Autowired
  CalculateService calculateService;

  @Override
  public ResponseEntity<ApiResp<ResultDTO>> calculator(String x, String y,
      String z) {
    ResultDTO resultDTO = ResultMapper.mapToResultDTO(x, y, z,
        calculateService.calculator(x, y, z));
    ApiResp<ResultDTO> apiresp =
        ApiResp.<ResultDTO>builder().success().resultDTO(resultDTO).build();
    return ResponseEntity.ok().body(apiresp);
  }

  @Override
  public ResponseEntity<ApiResp<ResultDTO>> calculatorJsonInput(
      @RequestBody ResultDTO jsoninput) {
    String x = jsoninput.getX();
    String y = jsoninput.getY();
    String z = jsoninput.getOperation();
    return ResponseEntity.ok()
        .body(ApiResp
            .<ResultDTO>builder().success().resultDTO(ResultMapper
                .mapToResultDTO(x, y, z, calculateService.calculator(x, y, z)))
            .build());
  }
}
