package pe.com.demoquarkus.repository;

import pe.com.demoquarkus.response.ExchangeRateResponse;

public interface ExchangeRateRepository {
    ExchangeRateResponse getExchangeRate();
}
