package operations;

import org.junit.jupiter.api.Test;
import functions.MathFunction;
import functions.SqrFunction;

import static org.junit.jupiter.api.Assertions.*;

public class LeftSteppingDifferentialOperatorTest {
    @Test
    public void testDerivativeOfSqrFunction() {
        MathFunction sqrFunction = new SqrFunction();

        double step = 1e-5;
        LeftSteppingDifferentialOperator operator = new LeftSteppingDifferentialOperator(step);

        MathFunction derivative = operator.derive(sqrFunction);

        assertEquals(0.0, derivative.apply(0.0), 1e-3);

        assertEquals(2.0, derivative.apply(1.0), 1e-3);

        assertEquals(4.0, derivative.apply(2.0), 1e-3);

        assertEquals(6.0, derivative.apply(3.0), 1e-3);

        assertEquals(10.0, derivative.apply(5.0), 1e-3);
    }
}