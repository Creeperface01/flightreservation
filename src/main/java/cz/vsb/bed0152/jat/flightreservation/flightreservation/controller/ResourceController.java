package cz.vsb.bed0152.jat.flightreservation.flightreservation.controller;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Resource;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.form.ResourceForm;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.repository.AbstractRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

import javax.transaction.Transactional;
import java.io.Serializable;

public abstract class ResourceController<T extends Resource> implements Serializable {

    @Getter
    @Setter
    private Mode mode = null;

    public abstract ResourceForm<T> getForm();

    public abstract AbstractRepository<T> getRepository();

    public void create() {
        setMode(Mode.CREATE);
    }

    public void edit(T entity) {
        val form = getForm();

        setMode(Mode.EDIT);
        form.setEntity(entity);
    }

    @Transactional
    public void submit(T entity) {
        val form = getForm();
        val repository = getRepository();

        if (getMode() == Mode.EDIT) {
            mergeEntities(entity);
        } else {
            repository.persist(entity);
        }

        setMode(null);

        form.reset();
        repository.flush();
    }

    public void mergeEntities(T edited) {
        val repository = getRepository();
        repository.merge(edited);
    }

    public void cancel() {
        val form = getForm();

        setMode(null);
        form.reset();
    }

    public enum Mode {
        CREATE,
        EDIT
    }
}
