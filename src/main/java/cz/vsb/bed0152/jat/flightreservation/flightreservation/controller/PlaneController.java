package cz.vsb.bed0152.jat.flightreservation.flightreservation.controller;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Plane;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.form.PlaneForm;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.repository.PlaneRepository;
import lombok.Getter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
@Getter
public class PlaneController extends ResourceController<Plane> {

    @Inject
    private PlaneForm form;

    @Inject
    private PlaneRepository repository;
}
