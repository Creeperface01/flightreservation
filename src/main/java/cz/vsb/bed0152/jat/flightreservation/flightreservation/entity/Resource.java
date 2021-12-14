package cz.vsb.bed0152.jat.flightreservation.flightreservation.entity;

public interface Resource {

    int getId();

    default String getPartialIdentifier() {
        return Integer.toString(getId());
    }
}
