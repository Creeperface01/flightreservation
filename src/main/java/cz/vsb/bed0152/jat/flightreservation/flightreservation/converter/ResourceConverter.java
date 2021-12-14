package cz.vsb.bed0152.jat.flightreservation.flightreservation.converter;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.bean.ResourceManager;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Resource;
import lombok.val;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "resourceConverter")
public class ResourceConverter implements Converter<Resource> {

    @SuppressWarnings({"unchecked", "rawtypes"})
    private Converter<Resource> resolveAttributes(UIComponent component) {
        val attributes = component.getAttributes();

        if (attributes.containsKey("resource_class")) {
            return null;
        }

        val clazz = attributes.get("resource_class");

        if (!(clazz instanceof Class)) {
            return null;
        }

        val manager = CDI.current().select(ResourceManager.class).get();

        return manager.getConverter((Class) clazz);
    }

    @Override
    public Resource getAsObject(FacesContext context, UIComponent component, String value) {
        val converter = resolveAttributes(component);

        if (converter == null) {
            return null;
        }

        return converter.getAsObject(context, component, value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Resource value) {
        val converter = resolveAttributes(component);

        if (converter == null) {
            return null;
        }

        return converter.getAsString(context, component, value);
    }
}
