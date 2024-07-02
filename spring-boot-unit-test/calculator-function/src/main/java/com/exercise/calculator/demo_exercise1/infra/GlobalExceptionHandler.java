package com.exercise.calculator.demo_exercise1.infra;

// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  // @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ApiResp<Void>> wrongOprExceptionHandler(
      IllegalArgumentException e) {
    ApiResp<Void> errorResult = ApiResp.<Void>builder()
        .fail(SysCode.INVALID_INPUT_OPR).resultDTO(null).build();
    return ResponseEntity.badRequest().body(errorResult);
  }

  @ExceptionHandler(NumberFormatException.class)
  // @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ApiResp<Void>> wrongNumExceptionHandler(
      NumberFormatException e) {
    ApiResp<Void> errorResult = ApiResp.<Void>builder()
        .fail(SysCode.INVALID_INPUT_NUM).resultDTO(null).build();
    return ResponseEntity.badRequest().body(errorResult);
  }

  @ExceptionHandler(ArithmeticException.class)
  // @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ApiResp<Void>> dividingByZeroExceptionHandler(
      ArithmeticException e) {
    ApiResp<Void> errorResult = ApiResp.<Void>builder()
        .fail(SysCode.INVALID_NUM_DIV).resultDTO(null).build();
    return ResponseEntity.badRequest().body(errorResult);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResp<Void>> ExceptionHandler(Exception e) {
    ApiResp<Void> errorResult = ApiResp.<Void>builder().build();
    return ResponseEntity.badRequest().body(errorResult);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ApiResp<Void>> RuntimeExceptionHandler(RuntimeException e) {
    ApiResp<Void> errorResult = ApiResp.<Void>builder().build();
    return ResponseEntity.badRequest().body(errorResult);
  }
}
