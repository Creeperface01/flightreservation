package cz.vsb.bed0152.jat.flightreservation.flightreservation.converter;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.component.user.Role;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Role.class, value = "roleConverter", managed = true)
public class RoleConverter implements Converter<Role> {

    @Override
    public Role getAsObject(FacesContext context, UIComponent component, String value) {
        return Role.valueOf(value.toUpperCase());
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Role value) {
        return value.name();
    }
}
