package cz.vsb.bed0152.jat.flightreservation.flightreservation.repository;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Plane;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
@ManagedBean
public class PlaneRepository extends AbstractRepository<Plane> {

    public PlaneRepository() {
        super(Plane.class);
    }
}
