package cz.vsb.bed0152.jat.flightreservation.flightreservation.bean;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.controller.ResourceController;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.Resource;
import lombok.SneakyThrows;
import lombok.val;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.Type;
import javax.persistence.metamodel.Type.PersistenceType;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
@ApplicationScoped
@Named
public class ResourceManager {

    @PersistenceContext
    private EntityManager entityManager;

    private final Map<Class<Resource>, Class<ResourceController<?>>> resources = new HashMap<>();

    private final Map<String, Class<Resource>> resourceNameMap = new HashMap<>();

    @PostConstruct
    public void init() {
        val emf = entityManager.getEntityManagerFactory();

        emf.getMetamodel().getManagedTypes().stream()
                .filter(t -> t.getPersistenceType() == PersistenceType.ENTITY)
                .map(Type::getJavaType)
                .forEach(clazz -> {
                    try {
                        resources.put(
                                (Class) clazz,
                                (Class) Class.forName("cz.vsb.bed0152.jat.flightreservation.flightreservation.controller." + clazz.getSimpleName() + "Controller")
                        );

                        resourceNameMap.put(clazz.getSimpleName(), (Class) clazz);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
    }

    public <T extends Resource> ResourceController<T> getController(Class<T> resourceClass) {
        val controllerClass = resources.get(resourceClass);
        return (ResourceController<T>) CDI.current().select(controllerClass).get();
    }

    @SneakyThrows
    public <T extends Resource> ResourceController<T> getController(String resourceClass) {
        return getController((Class) Class.forName(resourceClass));
    }

    public <T extends Resource> Class<T> getResource(String name) {
        val clazz = (Class) resourceNameMap.get(name);
        return (Class) resourceNameMap.get(name);
    }

    public <T extends Resource> Converter<T> getConverter(Class<T> resourceClass) {
        val controller = getController(resourceClass);

        return new Converter<T>() {
            @Override
            public T getAsObject(FacesContext context, UIComponent component, String value) {
                int id;

                try {
                    id = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    return null;
                }

                return controller.getRepository().find(id);
            }

            @Override
            public String getAsString(FacesContext context, UIComponent component, T value) {
                return Integer.toString(value.getId());
            }
        };
    }
}
