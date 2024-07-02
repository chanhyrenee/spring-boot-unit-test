package com.exercise.calculator.demo_exercise1.model;

public enum Operator {
  ADD("add"), SUB("sub"), MUL("mul"), DIV("div");

  private String symbol;

  Operator(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }

  public static Operator getSymbolType(String z) throws IllegalArgumentException{
    for (Operator symbol : Operator.values()) {
      if (symbol.getSymbol().equals(z)) {
        return symbol;
      }
    }
    throw new IllegalArgumentException();
  }
}
