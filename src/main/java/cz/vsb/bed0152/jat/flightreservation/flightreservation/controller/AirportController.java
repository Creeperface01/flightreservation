package cz.vsb.bed0152.jat.flightreservation.flightreservation.controller;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Airport;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.form.AirportForm;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.repository.AirportRepository;
import lombok.Getter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
@Getter
public class AirportController extends ResourceController<Airport> {

    @Inject
    private AirportForm form;

    @Inject
    private AirportRepository repository;

}
