package com.capx.assignmentProject.repositories;

import com.capx.assignmentProject.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByUserId(Long userId);
}
