package io.github.ahenteti.java.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SingletonDemo {
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10).forEach(i -> executor.execute(SingletonDemo::createAndPrintSingleton));
        executor.shutdown();
    }
    
    private static void createAndPrintSingleton() {
        ThreadSafeLazyInitializationSingleton singleton = ThreadSafeLazyInitializationSingleton.getInstance();
        System.out.println(singleton);
    }
}
