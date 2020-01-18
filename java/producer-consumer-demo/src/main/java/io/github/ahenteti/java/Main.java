package io.github.ahenteti.java;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Storage<String> queue = new StorageImpl<>(10);

        new Thread(new Producer("producer1", queue, 100)).start();
        new Thread(new Producer("producer2", queue, 200)).start();
        new Thread(new Consumer(queue, 300)).start();
        new Thread(new Consumer(queue, 400)).start();

        Thread.sleep(3000);
        System.exit(0);
    }
}
