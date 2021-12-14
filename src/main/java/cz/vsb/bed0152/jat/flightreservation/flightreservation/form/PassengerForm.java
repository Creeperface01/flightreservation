package cz.vsb.bed0152.jat.flightreservation.flightreservation.form;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Passenger;
import lombok.experimental.Delegate;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@ManagedBean
@RequestScoped
public class PassengerForm extends ResourceForm<Passenger> {

    @PostConstruct
    public void init() {
        factory = Passenger::new;

        super.init();
    }

    @Delegate
    public Passenger getEntity() {
        return this.entity;
    }
}
