package io.github.ahenteti.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScatterGatherPatternStep4 {

    public static final int THREAD_POOL_SIZE = 10;
    private String website1 = "url1";
    private String website2 = "url2";
    private String website3 = "url3";
    

    public static void main(String[] args) throws InterruptedException {
        ScatterGatherPatternStep4 scatterGatherPattern = new ScatterGatherPatternStep4();
        System.out.println(scatterGatherPattern.getProductPrices("P1"));
        scatterGatherPattern.threadPool.shutdown();
    }
    
    private ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public List<Double> getProductPrices(String productId) throws InterruptedException {
        List<Double> prices = Collections.synchronizedList(new ArrayList<>());

        CountDownLatch latch = new CountDownLatch(3);
        threadPool.submit(new GetProductPrice(productId, website1, prices, latch, 1000));
        threadPool.submit(new GetProductPrice(productId, website2, prices, latch, 1800));
        threadPool.submit(new GetProductPrice(productId, website3, prices, latch, 3000));
        latch.await(2, TimeUnit.SECONDS);

        return prices;
    }

    public class GetProductPrice implements Runnable {
        private String website;
        private String productId;
        private List<Double> prices;
        private CountDownLatch latch;
        private long timeout;

        public GetProductPrice(String website, String productId, List<Double> prices, CountDownLatch latch, long timeout) {
            this.website = website;
            this.productId = productId;
            this.prices = prices;
            this.latch = latch;
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



