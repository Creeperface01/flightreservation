package cz.vsb.bed0152.jat.flightreservation.flightreservation.controller;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.bean.FlightPurchase;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Flight;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.form.FlightForm;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.form.FlightSearch;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.form.PassengerForm;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.repository.FlightRepository;
import lombok.Getter;
import lombok.val;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
@Getter
public class FlightController extends ResourceController<Flight> {

    @Inject
    private FlightForm form;

    @Inject
    private FlightRepository repository;

    @Inject
    private FlightSearch flightSearch;

    @Inject
    private FlightPurchase flightPurchase;

    public void search(FlightSearch search) {
        val flights = repository.findByDatesAndAirports(
                search.getFrom(),
                search.getTo(),
                search.getAirportFrom(),
                search.getAirportTo()
        );

        this.flightSearch.setSearch(true);
        this.flightSearch.setResult(flights);
    }

    public void purchaseInit(Flight flight) {
        flightPurchase.setFlight(flight);
        flightPurchase.setFlightId(flight.getId());
    }

    public void purchase(FlightPurchase purchase, PassengerForm form) {
        purchase.getFlight().addPassenger(form.getEntity());
        repository.flush();
    }
}
