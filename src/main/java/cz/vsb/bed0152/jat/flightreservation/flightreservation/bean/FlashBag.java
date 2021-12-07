package cz.vsb.bed0152.jat.flightreservation.flightreservation.bean;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.util.BootstrapSeverity;
import lombok.Getter;
import lombok.Value;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Getter
@ManagedBean
@Named
@RequestScoped
public class FlashBag {

    private final List<Flash> flashes = new ArrayList<>();

    public void add(String message) {
        add("", message, BootstrapSeverity.INFO);
    }

    public void add(String message, BootstrapSeverity severity) {
        add("", message, severity);
    }

    public void add(String title, String message) {
        add(title, message, BootstrapSeverity.INFO);
    }

    public void add(String title, String message, BootstrapSeverity severity) {
        flashes.add(new Flash(title, message, severity));
    }

    @Value
    public static class Flash {

        public String title;
        public String message;

        public BootstrapSeverity severity;
    }
}
