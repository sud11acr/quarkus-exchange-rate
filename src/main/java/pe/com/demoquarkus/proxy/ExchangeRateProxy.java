package pe.com.demoquarkus.proxy;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import pe.com.demoquarkus.dto.ExchangeRateDto;

@RegisterRestClient(configKey = "api-proxy")
@Path("/tipo-cambio")
public interface ExchangeRateProxy {
    @GET
    @Path("/today.json")
    ExchangeRateDto getExchangeRate();
}
