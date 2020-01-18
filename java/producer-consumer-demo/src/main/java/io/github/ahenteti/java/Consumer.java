package io.github.ahenteti.java;

public class Consumer implements Runnable {
    private final Storage<String> queue;
    private final int processDuration;

    public Consumer(Storage<String> queue, int processDuration) {
        this.queue = queue;
        this.processDuration = processDuration;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String item = queue.remove();
                System.out.println("processing: " + item);
                Thread.sleep(processDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
