package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (t, u) -> t + u),
    MINUS("-", (t, u) -> t - u),
    MULTIPLY("*", (t, u) -> t * u),
    DIVIDE("/", (t, u) -> t / u);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String symbol,
        BiFunction<Integer, Integer, Integer> biFunction) {
        this.symbol = symbol;
        this.biFunction = biFunction;
    }

    public String getSymbol() {
        return symbol;
    }

    public BiFunction<Integer, Integer, Integer> getBiFunction() {
        return biFunction;
    }

}