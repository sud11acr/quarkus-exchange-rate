package pe.com.demoquarkus.controller;

import jakarta.inject.Inject;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import pe.com.demoquarkus.response.ExchangeRateResponse;
import pe.com.demoquarkus.service.ExchangeRateService;

@Path("/api/v1/exchange-rate")
@AllArgsConstructor
public class ExchangeRateController {

    @Inject
    ExchangeRateService exchangeRateService;

    @GET
    @Path("/{documentNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public ExchangeRateResponse getExchangeRate(@PathParam("documentNumber") 
    @Size(min = 8, max = 16) 
    @Pattern(regexp = "\\d+", message = "Solo se permiten números") 
    String documentNumber) {
        return exchangeRateService.getExchangeRate(documentNumber);
    }

}
