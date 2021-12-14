package cz.vsb.bed0152.jat.flightreservation.flightreservation.repository;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Airport;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Flight;
import lombok.val;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Collection;
import java.util.Date;

@Named
@ApplicationScoped
@ManagedBean
public class FlightRepository extends AbstractRepository<Flight> {

    public FlightRepository() {
        super(Flight.class);
    }

    public Collection<Flight> findByDatesAndAirports(
            Date fromDate,
            Date toDate,
            Airport fromAirport,
            Airport toAirport
    ) {
        val cb = getEntityManager().getCriteriaBuilder();

        val query = cb.createQuery(Flight.class);
        val from = query.from(Flight.class);

        query.where(
                cb.greaterThanOrEqualTo(from.get("departure"), fromDate),
                cb.lessThanOrEqualTo(from.get("arrival"), toDate),
                cb.equal(from.get("departureAirport"), fromAirport),
                cb.equal(from.get("arrivalAirport"), toAirport)
        );

        return getEntityManager().createQuery(query).getResultList();
    }
}
