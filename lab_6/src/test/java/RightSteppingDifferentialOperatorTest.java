import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import functions.MathFunction;
import operations.RightSteppingDifferentialOperator;

public class RightSteppingDifferentialOperatorTest {

    @Test
    public void testDerive() {
        // Устанавливаем шаг
        double step = 0.01;
        RightSteppingDifferentialOperator operator = new RightSteppingDifferentialOperator(step);

        // Определяем тестовую функцию f(x) = x^2
        MathFunction testFunction = new MathFunction() {
            @Override
            public double apply(double x) {
                return x * x;
            }
        };

        // Получаем производную
        MathFunction derivedFunction = operator.derive(testFunction);

        // Проверяем значение производной в точке x = 1
        double x = 1.0;
        double expectedDerivative = 2 * x; // Производная f(x) = x^2 равна 2x
        double actualDerivative = derivedFunction.apply(x);
    }

    @Test
    public void testDeriveAtZero() {
        double step = 0.01;
        RightSteppingDifferentialOperator operator = new RightSteppingDifferentialOperator(step);

        // Тестовая функция f(x) = x^3
        MathFunction testFunction = new MathFunction() {
            @Override
            public double apply(double x) {
                return x * x * x;
            }
        };

        MathFunction derivedFunction = operator.derive(testFunction);

        // Проверяем значение производной в точке x = 0
        double x = 0.0;
        double expectedDerivative = 0; // Производная f(x) = x^3 равна 0 в точке 0
        double actualDerivative = derivedFunction.apply(x);

        assertEquals(expectedDerivative, actualDerivative, 0.01);
    }

    @Test
    public void testNegativeValues() {
        double step = 0.01;
        RightSteppingDifferentialOperator operator = new RightSteppingDifferentialOperator(step);

        // Тестовая функция f(x) = sin(x)
        MathFunction testFunction = new MathFunction() {
            @Override
            public double apply(double x) {
                return Math.sin(x);
            }
        };

        MathFunction derivedFunction = operator.derive(testFunction);

        // Проверяем значение производной в точке x = -π/2
        double x = -Math.PI / 2;
        double expectedDerivative = Math.cos(x); // Производная f(x) = sin(x) равна cos(x)
        double actualDerivative = derivedFunction.apply(x);

        assertEquals(expectedDerivative, actualDerivative, 0.01);
    }
}