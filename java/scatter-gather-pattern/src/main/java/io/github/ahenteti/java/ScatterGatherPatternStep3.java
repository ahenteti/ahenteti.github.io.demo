package io.github.ahenteti.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.Arrays.stream;

public class ScatterGatherPatternStep3 {

    public static final int THREAD_POOL_SIZE = 10;
    private String website1 = "url1";
    private String website2 = "url2";
    private String website3 = "url3";
    

    public static void main(String[] args) throws InterruptedException {
        ScatterGatherPatternStep3 scatterGatherPattern = new ScatterGatherPatternStep3();
        System.out.println(scatterGatherPattern.getProductPrices("P1"));
    }
    
    private ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public List<Double> getProductPrices(String productId) throws InterruptedException {
        List<Double> prices = Collections.synchronizedList(new ArrayList<>());

        CountDownLatch latch = new CountDownLatch(3);
        threadPool.submit(new GetProductPrice(productId, website1, prices, latch));
        threadPool.submit(new GetProductPrice(productId, website2, prices, latch));
        threadPool.submit(new GetProductPrice(productId, website3, prices, latch));
        latch.await();

        return prices;
    }

    public class GetProductPrice implements Runnable {
        private String website;
        private String productId;
        private List<Double> prices;
        private CountDownLatch latch;

        public GetProductPrice(String website, String productId, List<Double> prices, CountDownLatch latch) {
            this.website = website;
            this.productId = productId;
            this.prices = prices;
            this.latch = latch;
        }

        @Override
        public void run() {
            prices.add(Math.random());
            latch.countDown();
        }
    }
}



