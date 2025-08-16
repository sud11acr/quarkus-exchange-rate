package pe.com.demoquarkus.service.impl;

import java.time.LocalDate;

import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pe.com.demoquarkus.entity.Exchange;
import pe.com.demoquarkus.exception.TooManyRequestsException;
import pe.com.demoquarkus.repository.ExchangeRateBdRepository;
import pe.com.demoquarkus.repository.ExchangeRateRepository;
import pe.com.demoquarkus.response.ExchangeRateResponse;
import pe.com.demoquarkus.service.ExchangeRateService;

@ApplicationScoped
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Inject
    ExchangeRateRepository exchangeRateRepository;

    @Inject
    ExchangeRateBdRepository exchangeRateBdRepository;

    @Inject
    Logger logger;

    @Override
    @Transactional
    public ExchangeRateResponse getExchangeRate(String documentNumber) {

        LocalDate currentDate = LocalDate.now();
        long count = exchangeRateBdRepository.countByDniAndDate(documentNumber, currentDate);
        if(count >=10){
            throw new TooManyRequestsException("Se ha superado el limite de consultas diarias");
        }
        ExchangeRateResponse exchangeRateResponse = exchangeRateRepository.getExchangeRate();
        Exchange exchange = new Exchange();
        exchange.setDocumentNumber(documentNumber);
        exchange.setRateDate(currentDate);
        exchangeRateBdRepository.persist(exchange);
        return exchangeRateResponse;
    }

}
