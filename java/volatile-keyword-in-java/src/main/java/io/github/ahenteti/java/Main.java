package io.github.ahenteti.java;

public class Main {

    private static volatile int sharedCounter = 0;

    public static void main(String[] args) {
        new SharedCounterWriter().start();
        new SharedCounterReader().start();
    }

    static class SharedCounterReader extends Thread {
        @Override
        public void run() {
            int counter = sharedCounter;
            while (counter < 5) {
                if (counter != sharedCounter) {
                    System.out.printf("sharedCounter new value : %d\n", sharedCounter);
                    counter = sharedCounter;
                }
            }
        }
    }

    static class SharedCounterWriter extends Thread {
        @Override
        public void run() {
            while (sharedCounter < 5) {
                System.out.printf("incrementing sharedCounter: %d\n", sharedCounter + 1);
                sharedCounter++;
                sleepQuietly(500);
            }
        }
    }

    private static void sleepQuietly(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
