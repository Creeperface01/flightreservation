package cz.vsb.bed0152.jat.flightreservation.flightreservation.util;

import lombok.Getter;

@Getter
public enum BootstrapSeverity {
    PRIMARY,
    SECONDARY,
    SUCCESS,
    DANGER,
    WARNING,
    INFO;

    private final String htmlName;

    BootstrapSeverity() {
        htmlName = name().toLowerCase();
    }
}
