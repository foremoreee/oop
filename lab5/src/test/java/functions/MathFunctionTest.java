package functions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathFunctionTest {

    @Test
    void testApply() {
        MathFunction square = new SimpleMathFunction(x -> x * x);
        assertEquals(4.0, square.apply(2.0));
        assertEquals(9.0, square.apply(3.0));
    }

    @Test
    void testAndThen() {
        MathFunction square = new SimpleMathFunction(x -> x * x);
        MathFunction increment = new SimpleMathFunction(x -> x + 1);

        MathFunction composite = square.andThen(increment);

        // (2^2) + 1 = 5
        assertEquals(5.0, composite.apply(2.0));
        // (3^2) + 1 = 10
        assertEquals(10.0, composite.apply(3.0));
    }

    @Test
    void testCompositeFunction() {
        MathFunction multiplyByTwo = new SimpleMathFunction(x -> x * 2);
        MathFunction addThree = new SimpleMathFunction(x -> x + 3);

        MathFunction composite = multiplyByTwo.andThen(addThree);

        // (2 * 2) + 3 = 7
        assertEquals(7.0, composite.apply(2.0));
        // (3 * 2) + 3 = 9
        assertEquals(9.0, composite.apply(3.0));
    }
}