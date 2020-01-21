package io.github.ahenteti.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ScatterGatherPatternStep5 {

    public static final int THREAD_POOL_SIZE = 10;
    private String website1 = "url1";
    private String website2 = "url2";
    private String website3 = "url3";


    public static void main(String[] args) throws Exception {
        ScatterGatherPatternStep5 scatterGatherPattern = new ScatterGatherPatternStep5();
        System.out.println(scatterGatherPattern.getProductPrices("P1"));
    }

    public List<Double> getProductPrices(String productId) throws Exception {
        List<Double> prices = Collections.synchronizedList(new ArrayList<>());

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new GetProductPrice(productId, website1, prices, 1000));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new GetProductPrice(productId, website2, prices, 1800));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new GetProductPrice(productId, website3, prices, 2400));
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        allTasks.completeOnTimeout(null, 2, TimeUnit.SECONDS).get();

        return prices;
    }

    public class GetProductPrice implements Runnable {
        private String website;
        private String productId;
        private List<Double> prices;
        private long timeout;

        public GetProductPrice(String website, String productId, List<Double> prices, long timeout) {
            this.website = website;
            this.productId = productId;
            this.prices = prices;
            this.timeout = timeout;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeout);
                prices.add(Math.random());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



