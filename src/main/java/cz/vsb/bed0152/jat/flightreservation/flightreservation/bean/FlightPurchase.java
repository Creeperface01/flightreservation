package cz.vsb.bed0152.jat.flightreservation.flightreservation.bean;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Flight;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.repository.FlightRepository;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ManagedBean
@SessionScoped
@Getter
@Setter
public class FlightPurchase implements Serializable {

    @Inject
    private FlightRepository flightRepository;

    private int flightId;

    private transient Flight flight;

    private boolean search;
    private Collection<Flight> result;

    @PostConstruct
    public void init() {
        if (flightId > 0) {
            flight = flightRepository.find(flightId);
        }
    }
}
