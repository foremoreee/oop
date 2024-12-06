package io;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.SqrFunction;
import functions.TabulatedFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        String arrayFilePath = "C://output/array_function.txt"; // путь для записи массива
        String linkedListFilePath = "C://output/linked_list_function.txt"; // путь для записи связного списка

        try (
                BufferedWriter bufferedArrayWriter = new BufferedWriter(new FileWriter(arrayFilePath));
                BufferedWriter bufferedLinkedListWriter = new BufferedWriter(new FileWriter(linkedListFilePath))
        ) {
            TabulatedFunction arrayFunction = new ArrayTabulatedFunction(
                    new double[]{1, 2, 3, 4, 5},
                    new double[]{1, 4, 9, 16, 25}
            );

            TabulatedFunction linkedListFunction = new LinkedListTabulatedFunction(
                    new double[]{1, 2, 3, 4, 5},
                    new double[]{5, 4, 3, 2, 1}
            );

            writeTabulatedFunction(bufferedArrayWriter, arrayFunction);
            writeTabulatedFunction(bufferedLinkedListWriter, linkedListFunction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
