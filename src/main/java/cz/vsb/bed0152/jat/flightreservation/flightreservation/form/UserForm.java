package cz.vsb.bed0152.jat.flightreservation.flightreservation.form;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.User;
import lombok.experimental.Delegate;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@ManagedBean
@RequestScoped
public class UserForm extends ResourceForm<User> {

    @PostConstruct
    public void init() {
        factory = User::new;

        super.init();
    }

    @Delegate
    public User getEntity() {
        return this.entity;
    }
}
