package cz.vsb.bed0152.jat.flightreservation.flightreservation.form;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Flight;
import lombok.experimental.Delegate;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@ManagedBean
@RequestScoped
public class FlightForm extends ResourceForm<Flight> {

    @PostConstruct
    public void init() {
        factory = Flight::new;

        super.init();
    }

    @Delegate
    public Flight getEntity() {
        return this.entity;
    }
}
