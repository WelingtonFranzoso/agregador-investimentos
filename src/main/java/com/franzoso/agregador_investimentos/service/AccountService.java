package com.franzoso.agregador_investimentos.service;

import com.franzoso.agregador_investimentos.client.BrapiClient;
import com.franzoso.agregador_investimentos.controller.dto.AccountStockResponseDTO;
import com.franzoso.agregador_investimentos.controller.dto.AssociateAccountStockDTO;
import com.franzoso.agregador_investimentos.controller.dto.CreateStockDTO;
import com.franzoso.agregador_investimentos.entity.AccountStock;
import com.franzoso.agregador_investimentos.entity.AccountStockId;
import com.franzoso.agregador_investimentos.repository.AccountRepository;
import com.franzoso.agregador_investimentos.repository.AccountStockRepository;
import com.franzoso.agregador_investimentos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Value("#{environment.TOKEN}")
    private String TOKEN;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private AccountStockRepository accountStockRepository;

    @Autowired
    private BrapiClient brapiClient;

    public void associateStock(String accountId, AssociateAccountStockDTO associateAccountStockDTO) {
        var account = accountRepository.findById(UUID.fromString(accountId)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        var stock = stockRepository.findById(associateAccountStockDTO.stockId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        var id = new AccountStockId(account.getAccountId(), stock.getStockId());
        var entity = new AccountStock(id,account, stock, associateAccountStockDTO.quantity());
        accountStockRepository.save(entity);
    }


    public List<AccountStockResponseDTO> listStocks(String accountId) {
        var account = accountRepository.findById(UUID.fromString(accountId)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return account.getAccountStock().stream().map(
                as -> new AccountStockResponseDTO(as.getStock().getStockId(),
                        as.getQuantity(),
                        getTotal(as.getQuantity(), as.getStock().getStockId()))).toList();
    }

    private double getTotal(Integer quantity, String stockId) {
        var response = brapiClient.getQuote(TOKEN, stockId);
        var price = response.results().get(0).regularMarketPrice();
        return quantity * price;
    }
}