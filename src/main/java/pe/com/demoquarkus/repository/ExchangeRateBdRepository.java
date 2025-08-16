package pe.com.demoquarkus.repository;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.com.demoquarkus.entity.Exchange;

@ApplicationScoped
public class ExchangeRateBdRepository implements PanacheRepository<Exchange> {

    public long countByDniAndDate(String documentNumber, LocalDate date) {
        return count("documentNumber = ?1 and rateDate = ?2", documentNumber, date);
    }

    public void persist(Exchange exchange) {
        if (exchange != null) {
            getEntityManager().persist(exchange);
        }
    }

}
