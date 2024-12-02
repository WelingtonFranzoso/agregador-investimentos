package com.franzoso.agregador_investimentos.repository;

import com.franzoso.agregador_investimentos.entity.AccountStock;
import com.franzoso.agregador_investimentos.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
}
