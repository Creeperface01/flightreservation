package cz.vsb.bed0152.jat.flightreservation.flightreservation.form;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Airport;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Collection;
import java.util.Date;

@RequestScoped
@ManagedBean
@Named
@Getter
@Setter
public class FlightSearch {

    private Date from;
    private Date to;

    private Airport airportFrom;
    private Airport airportTo;

    private boolean search;
    private Collection<Flight> result;

}
