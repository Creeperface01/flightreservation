package cz.vsb.bed0152.jat.flightreservation.flightreservation.repository;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Airport;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
@ManagedBean
public class AirportRepository extends AbstractRepository<Airport> {

    public AirportRepository() {
        super(Airport.class);
    }
}
