// OneDimensional.java
public final class OneDimensional {
    private OneDimensional() {}

    // Метод дихотомии
    public static Result bisect(IFunction1D function, double lhs, double rhs,
                                double eps, int maxIterations) {
        if (lhs > rhs) {
            double temp = lhs;
            lhs = rhs;
            rhs = temp;
        }

        int functionCalls = 0;
        int iterations = 0;

        while (iterations < maxIterations && (rhs - lhs) > 2 * eps) {
            double center = (lhs + rhs) / 2;
            double xl = center - eps / 10;
            double xr = center + eps / 10;

            double fl = function.call(xl);
            double fr = function.call(xr);
            functionCalls += 2;
            iterations++;

            if (fl > fr) {
                lhs = xl;
            } else {
                rhs = xr;
            }
        }

        double result = (lhs + rhs) / 2;
        double accuracy = (rhs - lhs) / 2;
        return new Result(result, functionCalls, accuracy);
    }

    public static Result bisect(IFunction1D function, double lhs, double rhs, double eps) {
        return bisect(function, lhs, rhs, eps, NumericCommon.ITERATIONS_COUNT_HIGH);
    }

    public static Result bisect(IFunction1D function, double lhs, double rhs) {
        return bisect(function, lhs, rhs, NumericCommon.NUMERIC_ACCURACY_MIDDLE);
    }

    // Метод золотого сечения
    public static Result goldenRatio(IFunction1D function, double lhs, double rhs,
                                     double eps, int maxIterations) {
        if (lhs > rhs) {
            double temp = lhs;
            lhs = rhs;
            rhs = temp;
        }

        int functionCalls = 2;
        int iterations = 0;

        double xl = rhs - NumericCommon.PSI * (rhs - lhs);
        double xr = lhs + NumericCommon.PSI * (rhs - lhs);

        double fl = function.call(xl);
        double fr = function.call(xr);

        while (iterations < maxIterations && (rhs - lhs) > 2 * eps) {
            iterations++;

            if (fl > fr) {
                lhs = xl;
                xl = xr;
                fl = fr;
                xr = lhs + NumericCommon.PSI * (rhs - lhs);
                fr = function.call(xr);
                functionCalls++;
            } else {
                rhs = xr;
                xr = xl;
                fr = fl;
                xl = rhs - NumericCommon.PSI * (rhs - lhs);
                fl = function.call(xl);
                functionCalls++;
            }
        }

        double result = (lhs + rhs) / 2;
        double accuracy = (rhs - lhs) / 2;
        return new Result(result, functionCalls, accuracy);
    }

    public static Result goldenRatio(IFunction1D function, double lhs, double rhs, double eps) {
        return goldenRatio(function, lhs, rhs, eps, NumericCommon.ITERATIONS_COUNT_HIGH);
    }

    public static Result goldenRatio(IFunction1D function, double lhs, double rhs) {
        return goldenRatio(function, lhs, rhs, NumericCommon.NUMERIC_ACCURACY_MIDDLE);
    }

    // Метод Фибоначчи
    public static Result fibonacci(IFunction1D function, double lhs, double rhs,
                                   double eps, int maxIterations) {
        if (lhs > rhs) {
            double temp = lhs;
            lhs = rhs;
            rhs = temp;
        }

        long fib1 = 1, fib2 = 1;
        int n = 1;

        while (fib2 < (rhs - lhs) / eps && n < maxIterations) {
            long next = fib1 + fib2;
            fib1 = fib2;
            fib2 = next;
            n++;
        }

        int functionCalls = 2;
        double xl, xr, fl, fr;

        xl = lhs + (double)(fib2 - fib1) / fib2 * (rhs - lhs);
        xr = lhs + (double)fib1 / fib2 * (rhs - lhs);
        fl = function.call(xl);
        fr = function.call(xr);

        for (int i = n - 1; i > 0; i--) {
            if (fl > fr) {
                lhs = xl;
                xl = xr;
                fl = fr;

                long temp = fib1;
                fib1 = fib2 - fib1;
                fib2 = temp;

                xr = lhs + (double)fib1 / fib2 * (rhs - lhs);
                fr = function.call(xr);
            } else {
                rhs = xr;
                xr = xl;
                fr = fl;

                long temp = fib1;
                fib1 = fib2 - fib1;
                fib2 = temp;

                xl = lhs + (double)(fib2 - fib1) / fib2 * (rhs - lhs);
                fl = function.call(xl);
            }
            functionCalls++;
        }

        double result = (lhs + rhs) / 2;
        double accuracy = (rhs - lhs) / 2;
        return new Result(result, functionCalls, accuracy);
    }

    public static Result fibonacci(IFunction1D function, double lhs, double rhs, double eps) {
        return fibonacci(function, lhs, rhs, eps, NumericCommon.ITERATIONS_COUNT_HIGH);
    }

    public static Result fibonacci(IFunction1D function, double lhs, double rhs) {
        return fibonacci(function, lhs, rhs, NumericCommon.NUMERIC_ACCURACY_MIDDLE);
    }

    public static class Result {
        private final double point;
        private final int functionCalls;
        private final double accuracy;

        public Result(double point, int functionCalls, double accuracy) {
            this.point = point;
            this.functionCalls = functionCalls;
            this.accuracy = accuracy;
        }

        public double getPoint() { return point; }
        public int getFunctionCalls() { return functionCalls; }
    }
}