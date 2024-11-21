package operations;

import org.junit.jupiter.api.Test;
import functions.ArrayTabulatedFunction;
import functions.Point;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.LinkedListTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;
import operations.TabulatedFunctionOperationService;

import static org.junit.jupiter.api.Assertions.*;

public class TabulatedFunctionOperationServiceTest {
    @Test
    void testPointsArrayTabulatedFunction() {
        double[] xArray = {2.0, 4.0, 6.0, 8.0};
        double[] yArray = {3.0, 6.0, 9.0, 12.0};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xArray, yArray);

        Point[] points = TabulatedFunctionOperationService.asPoints(arrayTabulatedFunction);

        assertEquals(xArray.length, points.length);

        for (int i = 0; i < xArray.length; i++) {
            assertEquals(xArray[i], points[i].x, 1e-9);
            assertEquals(yArray[i], points[i].y, 1e-9);
        }
    }

    @Test
    public void asPointsTest() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {1.0, 2.0, 3.0};

        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
        Point[] points = TabulatedFunctionOperationService.asPoints(function);

        assertEquals(3, points.length);
    }


    @Test
    public void SumTest() {
        TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionOperationService service = new TabulatedFunctionOperationService(factory);

        double[] xValues = {0.5, 1.5, 2.5};
        double[] yValues1 = {2.5, 4.5, 6.5};
        double[] yValues2 = {0.5, 1.5, 2.5};

        TabulatedFunction f1 = factory.create(xValues, yValues1);
        TabulatedFunction f2 = factory.create(xValues, yValues2);

        TabulatedFunction result = service.sum(f1, f2);
        double[] expectedY = {3.0, 6.0, 9.0};

        for (int i = 0; i < result.getCount(); i++) {
            assertEquals(expectedY[i], result.getY(i));
        }
    }

    @Test
    public void SubtractTest() {
        TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionFactory linkedListFactory = new LinkedListTabulatedFunctionFactory();
        TabulatedFunctionOperationService service = new TabulatedFunctionOperationService(arrayFactory);

        double[] xValues = {5.0, 10.0, 15.0};
        double[] yValues1 = {20.0, 30.0, 40.0};
        double[] yValues2 = {15.0, 20.0, 25.0};

        TabulatedFunction f1 = arrayFactory.create(xValues, yValues1);
        TabulatedFunction f2 = linkedListFactory.create(xValues, yValues2);

        TabulatedFunction result = service.subtract(f1, f2);
        double[] expectedY = {5.0, 10.0, 15.0};

        for (int i = 0; i < result.getCount(); i++) {
            assertEquals(expectedY[i], result.getY(i));
        }
    }






}