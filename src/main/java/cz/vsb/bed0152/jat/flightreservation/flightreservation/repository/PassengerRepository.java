package cz.vsb.bed0152.jat.flightreservation.flightreservation.repository;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Passenger;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
@ManagedBean
public class PassengerRepository extends AbstractRepository<Passenger> {

    public PassengerRepository() {
        super(Passenger.class);
    }
}
