package pe.com.demoquarkus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import pe.com.demoquarkus.dto.ExchangeRateDto;
import pe.com.demoquarkus.response.ExchangeRateResponse;

@Mapper
public interface ExchangeRateMapper {
    ExchangeRateMapper INSTANCE = Mappers.getMapper(ExchangeRateMapper.class);

    ExchangeRateResponse toExchangeRateResponse(ExchangeRateDto exchangeRateDto);
}
