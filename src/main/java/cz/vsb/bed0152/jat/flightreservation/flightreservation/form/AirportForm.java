package cz.vsb.bed0152.jat.flightreservation.flightreservation.form;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Airport;
import lombok.experimental.Delegate;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@ManagedBean
@RequestScoped
public class AirportForm extends ResourceForm<Airport> {

    @PostConstruct
    public void init() {
        factory = Airport::new;

        super.init();
    }

    @Delegate
    public Airport getEntity() {
        return this.entity;
    }
}
