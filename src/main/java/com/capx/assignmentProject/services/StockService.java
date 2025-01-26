package com.capx.assignmentProject.services;

import com.capx.assignmentProject.models.Stock;
import com.capx.assignmentProject.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;

@Service
public class StockService {
    private final StockRepository stockRepository;
    private final StockPriceService stockPriceService;

    public StockService(StockRepository stockRepository, StockPriceService stockPriceService) {
        this.stockRepository = stockRepository;
        this.stockPriceService = stockPriceService;
    }

    // Method to add a new stock
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    // Method to fetch all stocks for a specific user
    public List<Stock> getStocksByUserId(Long userId) {
        return stockRepository.findByUserId(userId);
    }

    // Method to delete a stock by ID
    public void deleteStock(Long stockId) {
        if (!stockRepository.existsById(stockId)) {
            throw new RuntimeException("Stock not found with id: " + stockId);
        }
        stockRepository.deleteById(stockId);
    }

    // Calculate the total portfolio value
    public BigDecimal calculatePortfolioValue(Long userId) {
        List<Stock> stocks = stockRepository.findByUserId(userId);
        BigDecimal totalValue = BigDecimal.ZERO;

        for (Stock stock : stocks) {
            BigDecimal livePrice = stockPriceService.getStockPrice(stock.getTicker());
            totalValue = totalValue.add(livePrice.multiply(BigDecimal.valueOf(stock.getQuantity())));
        }

        return totalValue;
    }

}
