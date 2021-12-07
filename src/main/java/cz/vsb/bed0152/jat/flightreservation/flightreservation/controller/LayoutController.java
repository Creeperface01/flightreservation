package cz.vsb.bed0152.jat.flightreservation.flightreservation.controller;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.bean.Router;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Airport;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Flight;
import lombok.val;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@ApplicationScoped
public class LayoutController {

    @Inject
    private Router router;

    @PersistenceContext
    private EntityManager entityManager;

    public Airport getFlights() {
        val entity = entityManager.find(Airport.class, 1);

        return entity;
    }
}
