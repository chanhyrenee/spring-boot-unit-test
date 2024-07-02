package com.exercise.calculator.demo_exercise1.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.exercise.calculator.demo_exercise1.model.Operator;
import com.exercise.calculator.demo_exercise1.service.CalculateService;

@Service
public class CalculateServiceImpl implements CalculateService {

  @Override
  public String calculator(String x, String y, String z) {
    double a = Double.parseDouble(x);
    double b = Double.parseDouble(y);
    Operator operator = Operator.getSymbolType(z);

    switch (operator) {
      case ADD:
        return add(a, b);
      case SUB:
        return sub(a, b);
      case MUL:
        return mul(a, b);
      case DIV:
        return div(a, b);
    }
    throw new IllegalArgumentException();
  }

  @Override
  public String add(double x, double y) {
    return BigDecimal.valueOf(x).add(BigDecimal.valueOf(y))
        .setScale(5, RoundingMode.HALF_UP).toString();
  }

  @Override
  public String sub(double x, double y) {
    return BigDecimal.valueOf(x).subtract(BigDecimal.valueOf(y))
        .setScale(5, RoundingMode.HALF_UP).toString();
  }

  @Override
  public String mul(double x, double y) {
    return BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y))
        .setScale(5, RoundingMode.HALF_UP).toString();
  }

  @Override
  public String div(double x, double y) {
    return BigDecimal.valueOf(x)
        .divide(BigDecimal.valueOf(y), 10, RoundingMode.HALF_UP) // fixed: Non-terminating decimal expansion; no exact representable decimal result.
        .setScale(5, RoundingMode.HALF_UP).toString();
  }
}
