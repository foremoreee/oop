package io;

import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.LinkedListTabulatedFunctionFactory;
import operations.TabulatedDifferentialOperator;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        String path = "input/binary function.bin";
        try (
                FileInputStream arrayFunctionReader = new FileInputStream(path);
                BufferedInputStream bufferedArrayFunctionReader = new BufferedInputStream(arrayFunctionReader);
        ) {
            TabulatedFunction arrayFunction = FunctionsIO.readTabulatedFunction(bufferedArrayFunctionReader, new ArrayTabulatedFunctionFactory());
            System.out.println(arrayFunction);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader streamReader = new InputStreamReader(System.in);
        System.out.print("Введите размер и значения функции: ");
        BufferedReader reader = new BufferedReader(streamReader);
        try {
            TabulatedFunction linkedListFunctionFromConsole = FunctionsIO.readTabulatedFunction(reader, new LinkedListTabulatedFunctionFactory());
            System.out.println(new TabulatedDifferentialOperator().derive(linkedListFunctionFromConsole));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
