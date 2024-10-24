package functions;

import functions.CompositeFunction;
import functions.IdentityFunction;
import functions.MathFunction;
import functions.SqrFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompositeFunctionTest {
    @Test
    void testCompositeFunctions() {
        MathFunction sqrFunction = new SqrFunction();
        MathFunction identityFunctions=new IdentityFunction();
        CompositeFunction compositeFunction1 = new CompositeFunction(sqrFunction, sqrFunction);
        CompositeFunction compositeFunction2 = new CompositeFunction(identityFunctions, sqrFunction);
        CompositeFunction compositeFunction3 = new CompositeFunction(identityFunctions, identityFunctions);

        assertEquals(16, compositeFunction1.apply(2));
        assertEquals(4, compositeFunction2.apply(2));
        assertEquals(2, compositeFunction3.apply(2));
    }
}