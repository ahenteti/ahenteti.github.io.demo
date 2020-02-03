package io.github.ahenteti.java.singleton;

public class ThreadSafeLazyInitializationSingleton {
    
    private static ThreadSafeLazyInitializationSingleton instance = null;

    private ThreadSafeLazyInitializationSingleton() {
        try {
            Thread.sleep(50); // simulate creation delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ThreadSafeLazyInitializationSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeLazyInitializationSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeLazyInitializationSingleton();
                }
            }
        }
        return instance;
    }
}
