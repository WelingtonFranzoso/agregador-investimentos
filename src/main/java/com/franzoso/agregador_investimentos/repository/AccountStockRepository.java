package com.franzoso.agregador_investimentos.repository;

import com.franzoso.agregador_investimentos.entity.AccountStock;
import com.franzoso.agregador_investimentos.entity.AccountStockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockId> {
}
