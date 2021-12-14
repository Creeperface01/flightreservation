package cz.vsb.bed0152.jat.flightreservation.flightreservation.controller;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.User;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.form.UserForm;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.repository.UserRepository;
import lombok.Getter;
import lombok.val;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
@Getter
public class UserController extends ResourceController<User> {

    @Inject
    private UserForm form;

    @Inject
    private UserRepository repository;

    @Override
    public void mergeEntities(User edited) {
        val existing = repository.find(edited.getId());

        existing.setName(edited.getName());
        existing.setSurname(edited.getSurname());
        existing.setRole(edited.getRole());
        existing.setBirthDate(edited.getBirthDate());
    }
}
