package io.github.ahenteti.java;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SimpleDateFormatStep2 {

    public static void main(String[] args) {
        final String stringDate = "2020-01-19T19:00:00";
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable task = () -> parseDate(stringDate);
        IntStream.rangeClosed(1, 100).forEach(i -> executorService.submit(task));
        executorService.shutdown();
    }

    private static void parseDate(String stringDate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = formatter.parse(stringDate);
            System.out.println("Date: " + date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
