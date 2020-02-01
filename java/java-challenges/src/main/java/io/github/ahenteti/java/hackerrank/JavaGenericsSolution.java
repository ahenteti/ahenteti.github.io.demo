package io.github.ahenteti.java.hackerrank;

import java.lang.reflect.Method;

class JavaGenericsSolutionPrinter {
    <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

class JavaGenericsSolutionMain {


    public static void main(String args[]) {
        JavaGenericsSolutionPrinter myPrinter = new JavaGenericsSolutionPrinter();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : JavaGenericsSolutionPrinter.class.getDeclaredMethods()) {
            String name = method.getName();
            if (name.equals("printArray")) count++;
        }

        if (count > 1) System.out.println("Method overloading is not allowed!");

    }
}