package com.franzoso.agregador_investimentos.repository;

import com.franzoso.agregador_investimentos.entity.BillingAddress;
import com.franzoso.agregador_investimentos.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, UUID> {
}
