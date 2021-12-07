package cz.vsb.bed0152.jat.flightreservation.flightreservation.validator;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.User;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class UserRegisterValidator implements Validator<User> {

    @Override
    public void validate(FacesContext context, UIComponent component, User value) throws ValidatorException {

    }
}
