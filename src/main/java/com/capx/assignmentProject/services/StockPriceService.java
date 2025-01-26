package com.capx.assignmentProject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class StockPriceService {
    private static final String API_URL = "https://www.alphavantage.co/query";
    private static final String API_KEY = "VY92GF14HNF7LR1A";

    public BigDecimal getStockPrice(String ticker) {
        RestTemplate restTemplate = new RestTemplate();

        // Query parameters
        Map<String, String> params = new HashMap<>();
        params.put("function", "GLOBAL_QUOTE");
        params.put("symbol", ticker);
        params.put("apikey", API_KEY);

        // Make API request
        try {
            String url = API_URL + "?function={function}&symbol={symbol}&apikey={apikey}";
            Map response = restTemplate.getForObject(url, Map.class, params);

            // Extract the stock price
            Map<String, Object> quote = (Map<String, Object>) response.get("Global Quote");
            String priceString = (String) quote.get("05. price");
            return new BigDecimal(priceString);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching stock price for ticker: " + ticker, e);
        }
    }
}
