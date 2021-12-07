package cz.vsb.bed0152.jat.flightreservation.flightreservation.Form;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
@Getter
@Setter
public class AuthForm implements Serializable {

    private User user = new User();

}
