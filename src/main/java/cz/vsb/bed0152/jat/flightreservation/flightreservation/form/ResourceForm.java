package cz.vsb.bed0152.jat.flightreservation.flightreservation.form;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Resource;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Supplier;

@Setter
public abstract class ResourceForm<T extends Resource> {

    protected transient Supplier<T> factory;

    @Getter
    protected T entity;

    public void init() {
        entity = factory.get();
    }

    public void reset() {
        entity = factory.get();
    }
}
