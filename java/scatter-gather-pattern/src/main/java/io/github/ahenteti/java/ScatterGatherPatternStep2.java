package io.github.ahenteti.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScatterGatherPatternStep2 {

    public static final int THREAD_POOL_SIZE = 10;
    private String website1 = "url1";
    private String website2 = "url2";
    private String website3 = "url3";

    public static void main(String[] args) {
        ScatterGatherPatternStep2 scatterGatherPattern = new ScatterGatherPatternStep2();
        System.out.println(scatterGatherPattern.getProductPrices("P1"));
    }

    private ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public List<Double> getProductPrices(String productId) {
        List<Double> prices = Collections.synchronizedList(new ArrayList<>());
        threadPool.submit(new GetProductPrice(productId, website1, prices));
        threadPool.submit(new GetProductPrice(productId, website2, prices));
        threadPool.submit(new GetProductPrice(productId, website3, prices));
        return prices;
    }

    public static class GetProductPrice implements Runnable {
        private String website;
        private String productId;
        private List<Double> prices;

        public GetProductPrice(String website, String productId, List<Double> prices) {
            this.website = website;
            this.productId = productId;
            this.prices = prices;
        }

        @Override
        public void run() {
            prices.add(Math.random());
        }
    }
}
