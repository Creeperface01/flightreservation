package cz.vsb.bed0152.jat.flightreservation.flightreservation.form;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Plane;
import lombok.experimental.Delegate;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@ManagedBean
@RequestScoped
public class PlaneForm extends ResourceForm<Plane> {

    @PostConstruct
    public void init() {
        factory = Plane::new;

        super.init();
    }

    @Delegate
    public Plane getEntity() {
        return this.entity;
    }
}
