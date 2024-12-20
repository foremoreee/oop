package io;

import functions.LinkedListTabulatedFunction;
import functions.TabulatedFunction;
import functions.factory.LinkedListTabulatedFunctionFactory;
import operations.TabulatedDifferentialOperator;

import java.io.*;
import java.nio.file.Paths;

public class LinkedListTabulatedFunctionSerialization {

    public static void main(String[] args) {
        String filePath = Paths.get("C:\\Users\\ilham\\IdeaProjects\\lab_5\\output\\serialized_linked_list_functions.bin").toString();

        TabulatedFunction linkedListTabulatedFunction =
                new LinkedListTabulatedFunction(new double[]{1, 2, 3}, new double[]{4, 5, 6});

        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator();
        TabulatedFunction firstDerivative = differentialOperator.derive(linkedListTabulatedFunction);
        TabulatedFunction secondDerivative = differentialOperator.derive(firstDerivative);

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {
            FunctionsIO.serialize(bufferedOutputStream, linkedListTabulatedFunction);
            FunctionsIO.serialize(bufferedOutputStream, firstDerivative);
            FunctionsIO.serialize(bufferedOutputStream, secondDerivative);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            TabulatedFunction deserializedLinkedListTabulatedFunction = FunctionsIO.deserialize(bufferedInputStream);
            TabulatedFunction deserializedFirstDerivative = FunctionsIO.deserialize(bufferedInputStream);
            TabulatedFunction deserializedSecondDerivative = FunctionsIO.deserialize(bufferedInputStream);

            System.out.println("Исходная функция: " + deserializedLinkedListTabulatedFunction.toString());
            System.out.println("Первая производная исходной функции: " + deserializedFirstDerivative.toString());
            System.out.println("Вторая производная исходной функции: " + deserializedSecondDerivative.toString());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}