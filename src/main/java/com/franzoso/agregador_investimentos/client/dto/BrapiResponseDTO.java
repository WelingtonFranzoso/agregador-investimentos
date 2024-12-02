package com.franzoso.agregador_investimentos.client.dto;

import java.util.List;

public record BrapiResponseDTO(List<StockDTO> results) {
}
