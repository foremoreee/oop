package concurrent;

import functions.ConstantFunction;
import functions.LinkedListTabulatedFunction;

public class ReadWriteTaskExecutor {
    public static void main(String[] args) {
        LinkedListTabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(new ConstantFunction(-1),1,1000,1000);
        Thread readTaskThread = new Thread(new ReadTask(linkedListTabulatedFunction));
        Thread writeTaskThread = new Thread(new WriteTask(linkedListTabulatedFunction, 0.5));
        writeTaskThread.start();
        readTaskThread.start();
    }
}