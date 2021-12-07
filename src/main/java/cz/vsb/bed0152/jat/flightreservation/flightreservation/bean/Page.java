package cz.vsb.bed0152.jat.flightreservation.flightreservation.bean;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Page {
    ;

    private final String name;
    private final String route;
    private final String path;

}
