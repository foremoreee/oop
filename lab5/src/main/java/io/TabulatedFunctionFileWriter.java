package io;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.SqrFunction;
import functions.TabulatedFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabulatedFunctionFileWriter {
    public static void main(String[] args){
        String arrayFunctionLinePath = "C:/Users/ilham/IdeaProjects/lab_5/output/array function.txt";
        String linkedListFunctionLinePath = "C:/Users/ilham/IdeaProjects/lab_5/output/linked list function.txt";

        try(
                BufferedWriter arrayWrite = new BufferedWriter(new FileWriter(arrayFunctionLinePath));
                BufferedWriter linkedWrite = new BufferedWriter(new FileWriter(linkedListFunctionLinePath));
        ) {
            TabulatedFunction arrayFunction = new ArrayTabulatedFunction(new SqrFunction(), 0, 10, 5);
            TabulatedFunction linkedListFunction = new LinkedListTabulatedFunction(new double[]{1,2,3}, new double[]{1, 4, 9});

            FunctionsIO.writeTabulatedFunction(arrayWrite, arrayFunction);
            FunctionsIO.writeTabulatedFunction(linkedWrite, linkedListFunction);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}