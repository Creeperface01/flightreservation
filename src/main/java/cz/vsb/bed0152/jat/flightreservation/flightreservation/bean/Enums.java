package cz.vsb.bed0152.jat.flightreservation.flightreservation.bean;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.component.user.Role;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Enums {

    public Role[] getRoles() {
        return Role.values();
    }
}
