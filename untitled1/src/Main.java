// Main.java
public class Main {
    public static void main(String[] args) {
        IFunction1D testFunction = x -> x * x + 2 * x + 1;

        double lhs = -5;
        double rhs = 5;
        double eps = 1e-6;

        System.out.println("Testing optimization methods for f(x) = x^2 + 2x + 1");
        System.out.println("Search interval: [" + lhs + ", " + rhs + "]");
        System.out.println("Target accuracy: " + eps);
        System.out.println();
        OneDimensional.Result bisectResult = OneDimensional.bisect(testFunction, lhs, rhs, eps);
        OneDimensional.Result goldenResult = OneDimensional.goldenRatio(testFunction, lhs, rhs, eps);
        OneDimensional.Result fibonacciResult = OneDimensional.fibonacci(testFunction, lhs, rhs, eps);

        System.out.println("Results");
        System.out.printf("Exact minimum: x = %.10f\n", -1.0);
        System.out.printf("Bisection:     x = %.10f (error: %.10f, calls: %d)\n",
                bisectResult.getPoint(), Math.abs(bisectResult.getPoint() + 1), bisectResult.getFunctionCalls());
        System.out.printf("Golden Ratio:  x = %.10f (error: %.10f, calls: %d)\n",
                goldenResult.getPoint(), Math.abs(goldenResult.getPoint() + 1), goldenResult.getFunctionCalls());
        System.out.printf("Fibonacci:     x = %.10f (error: %.10f, calls: %d)\n",
                fibonacciResult.getPoint(), Math.abs(fibonacciResult.getPoint() + 1), fibonacciResult.getFunctionCalls());
    }
}