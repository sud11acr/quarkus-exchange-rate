package pe.com.demoquarkus.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExchangeRateDto {
    private String fecha;
    private double sunat;
    private double compra;
    private double venta;
}
