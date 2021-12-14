package cz.vsb.bed0152.jat.flightreservation.flightreservation.form;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.User;
import lombok.Getter;
import lombok.experimental.Delegate;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@ManagedBean
@RequestScoped
@Getter
public class AuthForm {

    @Delegate
    private final User user = new User();

}
