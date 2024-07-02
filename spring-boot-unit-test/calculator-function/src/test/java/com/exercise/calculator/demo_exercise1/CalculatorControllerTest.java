package com.exercise.calculator.demo_exercise1;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.exercise.calculator.demo_exercise1.controller.impl.CalculatorController;
import com.exercise.calculator.demo_exercise1.service.CalculateService;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CalculateService calculateServiceMock;

  @Test
  void testUrlStatus() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/v1/calculator")
            .param("x", "hello").param("y", "123").param("z", ""))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void testJsonOutput() throws Exception {
    when(calculateServiceMock.calculator("1.2", "3", "add")).thenReturn("4.20000");
    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/v1/calculator")
            .param("x", "1.2").param("y", "3").param("z", "add"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("1000"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("Success."))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.x").value("1.2"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.y").value("3"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.operation").value("add"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.result").value("4.20000"));;
  }

/*
 * Postman:
{
    "code": "1000",
    "msg": "Success.",
    "data": {
        "x": "1.2",
        "y": "3",
        "operation": "add",
        "result": "4.20000"
    }
}
 */
}

