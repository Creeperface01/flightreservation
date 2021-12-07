package cz.vsb.bed0152.jat.flightreservation.flightreservation.bean;

import lombok.Getter;
import lombok.experimental.Accessors;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@ManagedBean
@RequestScoped
@Named
@Getter
public class Router {

    private final String home = "/index.xhtml";
    private final String userIndex = "/pages/user/index.xhtml";
    private final String airportIndex = "/pages/airport/index.xhtml";
    private final String flightIndex = "/pages/flight/index.xhtml";
    private final String planeIndex = "/pages/plane/index.xhtml";


}
