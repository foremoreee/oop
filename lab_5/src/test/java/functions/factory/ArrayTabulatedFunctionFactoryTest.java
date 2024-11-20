package functions.factory;

import functions.ArrayTabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionFactoryTest {
    @Test
    void testEqual(){
        ArrayTabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
        assertInstanceOf(ArrayTabulatedFunction.class, factory.create(new double[]{0, 1, 2}, new double[]{3, 4, 5}));
    }
}
