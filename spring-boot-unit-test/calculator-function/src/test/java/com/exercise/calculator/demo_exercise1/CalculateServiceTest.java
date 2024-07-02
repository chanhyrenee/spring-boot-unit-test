package com.exercise.calculator.demo_exercise1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.exercise.calculator.demo_exercise1.model.Operator;
import com.exercise.calculator.demo_exercise1.service.CalculateService;

@SpringBootTest
public class CalculateServiceTest {

  @Autowired
  private CalculateService calculateService;

  @Test
  void testCalculatorParamxyz() {
    assertEquals(123, Double.parseDouble("0123"));
    assertEquals(45.6, Double.parseDouble("45.6"));
    assertEquals(Operator.ADD, Operator.getSymbolType("add"));
    assertThrows(NumberFormatException.class, () -> Double.parseDouble(""));
    assertThrows(NumberFormatException.class, () -> Double.parseDouble("one"));
    assertThrows(IllegalArgumentException.class,
        () -> Operator.getSymbolType("opr"));
    assertThrows(IllegalArgumentException.class,
        () -> Operator.getSymbolType(""));
  }

  @Test
  void testCalculatorFormula() {
    assertEquals("57.90000", calculateService.add(12.3, 45.6));
    assertEquals("-33.30000", calculateService.sub(12.3, 45.6));
    assertEquals("560.88000", calculateService.mul(12.3, 45.6));
    assertEquals("0.26974", calculateService.div(12.3, 45.6));
    assertThrows(ArithmeticException.class, () -> calculateService.div(3, 0));
  }

  @Test
  void testCalculatorSwitch() {
    double a = 98.7;
    double b = 78.9;
    // Mockito.when(calculateService.add(a, b)).thenReturn("177.60000");
    // Mockito.when(calculateService.sub(a, b)).thenReturn("19.80000");
    // Mockito.when(calculateService.mul(a, b)).thenReturn("7787.43000");
    // Mockito.when(calculateService.div(a, b)).thenReturn("1.25095");
    assertEquals("177.60000",
        calculateService.calculator("98.7", "78.9", "add"));
    assertEquals("19.80000",
        calculateService.calculator("98.7", "78.9", "sub"));
    assertEquals("7787.43000",
        calculateService.calculator("98.7", "78.9", "mul"));
    assertEquals("1.25095", calculateService.calculator("98.7", "78.9", "div"));
    assertThrows(IllegalArgumentException.class,
        () -> calculateService.calculator("98.7", "78.9", null));
  }
}
