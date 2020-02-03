package io.github.ahenteti.java.singleton;

public class LazyInitializationSingleton {
    
    private static LazyInitializationSingleton instance = null;

    private LazyInitializationSingleton() {
        try {
            Thread.sleep(50); // simulate creation delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static LazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }
}
