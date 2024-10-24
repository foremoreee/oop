package functions;

import functions.ArrayTabulatedFunction;
import functions.MathFunction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionTest {

    @Test
    void testConstructor() {
        double[] xValues = {1.0, 2.0, 3.0, 4.0};
        double[] yValues = {2.0, 4.0, 6.0, 8.0};

        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertEquals(4, function.getCount());

        for (int i = 0; i < function.getCount(); i++) {
            assertEquals(xValues[i], function.getX(i), 1e-9);
            assertEquals(yValues[i], function.getY(i), 1e-9);
        }
        assertEquals(1.0, function.leftBound());
        assertEquals(4.0, function.rightBound());
    }

    @Test
    void testConstructorLengths() {
        double[] xValues = {1.0, 2.0, 6.0};
        double[] yValues = {4.0, 5.0};

        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(xValues, yValues));
    }

    @Test
    void testConstructorSorted() {
        double[] xValues = {1.0, 5.0, 2.0};
        double[] yValues = {2.0, 3.0, 4.0};

        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(xValues, yValues));
    }

    @Test
    void testConstructorOnly() {
        double[] xValues = {1.0};
        double[] yValues = {2.0};

        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(xValues, yValues));
    }

    @Test
    void testConstructorWithFunctionValuesEqual(){
        MathFunction function = x -> Math.pow(x,2) - 1;
        double xFrom = 4.0;
        double xTo = 1.0;
        int count = 6;

        ArrayTabulatedFunction Arr = new ArrayTabulatedFunction(function, xFrom, xTo, count);

        double[] rightX = {1.0, 1.5, 2.0, 2.5, 3.0, 3.5};
        double[] rightY = {0.0, 1.25, 3.0, 5.25, 8, 11.25};

        for (int i = 0; i < Arr.getCount(); i++) {
            assertEquals(rightX[i], Arr.getX(i), 1);
            assertEquals(rightY[i], Arr.getY(i),1);
        }
    }

    @Test
    void testInterpolate() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {1.0, 2.0, 3.0};

        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertEquals(2.5, function.apply(2.5), 1e-9);
    }

    @Test
    void testInterpolateException() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {1.0, 2.0, 3.0};

        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertThrows(IllegalArgumentException.class, () -> function.interpolate(3.5, 1));
    }

    @Test
    void testExtrapolateLeft() {
        double[] xValues = {1.0, 2.0, 3.0, 4.0};
        double[] yValues = {2.0, 3.0, 4.0, 5.0};

        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertEquals(1.0, function.apply(0.0), 0.001);
    }

    @Test
    void testExtrapolateRight() {
        double[] xValues = {1.0, 2.0, 3.0, 4.0};
        double[] yValues = {2.0, 3.0, 4.0, 5.0};

        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertEquals(6.0, function.apply(5.0), 0.001);
    }

    @Test
    void testGetSetY() {
        double[] xValues = {1.0, 2.0, 3.0, 4.0};
        double[] yValues = {2.0, 3.0, 5.0, 6.0};

        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        assertEquals(3.0, function.getY(1), 0.001);
    }

    @Test
    public void testToString() {
        double[] xValues = {1, 2, 3};
        double[] yValues = {2, 4, 6};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        assertEquals("ArrayTabulatedFunction:\nx: 1.0, y: 2.0\nx: 2.0, y: 4.0\nx: 3.0, y: 6.0\n", function.toString());
    }

    @Test
    public void testEquals() {
        double[] xValues = {1, 2, 3};
        double[] yValues = {2, 4, 6};
        ArrayTabulatedFunction function1 = new ArrayTabulatedFunction(xValues, yValues);
        ArrayTabulatedFunction function2 = new ArrayTabulatedFunction(xValues, yValues);
        assertEquals(function1, function2);
    }
    @Test
    public void testHashCode() {
        double[] xValues = {1, 2, 3};
        double[] yValues = {2, 4, 6};
        ArrayTabulatedFunction function1 = new ArrayTabulatedFunction(xValues, yValues);
        ArrayTabulatedFunction function2 = new ArrayTabulatedFunction(xValues, yValues);
        assertEquals(function1.hashCode(), function2.hashCode());
    }

    @Test
    public void testClone() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        ArrayTabulatedFunction clonedFunction = function.clone();

        assertEquals(function, clonedFunction);
        assertNotSame(function, clonedFunction);
    }

}