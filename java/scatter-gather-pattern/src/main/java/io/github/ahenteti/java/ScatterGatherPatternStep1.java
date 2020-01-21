package io.github.ahenteti.java;

import java.util.ArrayList;
import java.util.List;

public class ScatterGatherPatternStep1 {
    public static void main(String[] args) {
        System.out.println(getProductPrices("P1", "url1", "url2", "url3"));
    }

    public static List<Double> getProductPrices(String productId, String... websites) {
        List<Double> prices = new ArrayList<>();
        for (String website : websites) {
            prices.add(getProductPrice(productId, website));
        }
        return prices;
    }

    private static Double getProductPrice(String productId, String website) {
        return Math.random();
    }
}