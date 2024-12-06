package functions;

public class SimpleMathFunction implements MathFunction {
    private final java.util.function.Function<Double, Double> function;

    public SimpleMathFunction(java.util.function.Function<Double, Double> function) {
        this.function = function;
    }

    @Override
    public double apply(double x) {
        return function.apply(x);
    }
}