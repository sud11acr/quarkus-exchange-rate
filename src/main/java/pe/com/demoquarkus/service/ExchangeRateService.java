package pe.com.demoquarkus.service;

import pe.com.demoquarkus.response.ExchangeRateResponse;

public interface ExchangeRateService {

    ExchangeRateResponse getExchangeRate(String dni);

}
