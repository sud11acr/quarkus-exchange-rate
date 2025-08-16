package pe.com.demoquarkus.repository.impl;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import pe.com.demoquarkus.dto.ExchangeRateDto;
import pe.com.demoquarkus.mapper.ExchangeRateMapper;
import pe.com.demoquarkus.proxy.ExchangeRateProxy;
import pe.com.demoquarkus.repository.ExchangeRateRepository;
import pe.com.demoquarkus.response.ExchangeRateResponse;

@ApplicationScoped

public class ExchangeRateRepositoryImpl implements ExchangeRateRepository{

    @Inject
    Logger logger;

    private final ExchangeRateProxy exchangeRateProxy;
    public ExchangeRateRepositoryImpl(@RestClient ExchangeRateProxy exchangeRateProxy) {
        this.exchangeRateProxy = exchangeRateProxy;
    }

    @Override
    public ExchangeRateResponse getExchangeRate() {
        ExchangeRateDto exchangeRateDto = exchangeRateProxy.getExchangeRate();
        logger.info("Obteniendo tasa de cambio: " + exchangeRateDto.getCompra());
        return ExchangeRateMapper.INSTANCE
        .toExchangeRateResponse(exchangeRateProxy.getExchangeRate());
    }


}
