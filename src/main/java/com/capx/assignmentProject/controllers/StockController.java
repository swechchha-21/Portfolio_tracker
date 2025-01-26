package com.capx.assignmentProject.controllers;

import com.capx.assignmentProject.models.Stock;
import com.capx.assignmentProject.services.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // Endpoint to add a new stock
    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    // Endpoint to fetch all stocks for a specific user
    @GetMapping("/user/{userId}")
    public List<Stock> getStocksByUserId(@PathVariable Long userId) {
        return stockService.getStocksByUserId(userId);
    }

    // Endpoint to delete a stock by ID
    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }

    // Endpoint to calculate portfolio value
    @GetMapping("/user/{userId}/value")
    public BigDecimal getPortfolioValue(@PathVariable Long userId) {
        return stockService.calculatePortfolioValue(userId);
    }
}
