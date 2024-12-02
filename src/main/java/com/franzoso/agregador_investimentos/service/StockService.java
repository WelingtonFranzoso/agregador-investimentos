package com.franzoso.agregador_investimentos.service;

import com.franzoso.agregador_investimentos.controller.dto.CreateStockDTO;
import com.franzoso.agregador_investimentos.entity.Stock;
import com.franzoso.agregador_investimentos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public void createStock(CreateStockDTO createStockDTO) {
        var stock = new Stock(createStockDTO.stockId(), createStockDTO.description());
        stockRepository.save(stock);
    }
}
