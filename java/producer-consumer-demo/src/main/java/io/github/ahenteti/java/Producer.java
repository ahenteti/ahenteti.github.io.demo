package io.github.ahenteti.java;

public class Producer implements Runnable {

    private final String name;
    private final Storage<String> queue;
    private final int processDuration;

    public Producer(String name, Storage<String> queue, int processDuration) {
        this.name = name;
        this.queue = queue;
        this.processDuration = processDuration;
    }

    @Override
    public void run() {
        int index = 0;
        while (true) {
            try {
                queue.add("item" + index++ + " from " + name);
                Thread.sleep(processDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
