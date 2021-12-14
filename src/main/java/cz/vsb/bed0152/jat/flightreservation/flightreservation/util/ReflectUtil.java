package cz.vsb.bed0152.jat.flightreservation.flightreservation.util;

import com.google.common.primitives.Primitives;
import lombok.SneakyThrows;
import lombok.val;
import lombok.var;
import org.joor.Reflect;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named
public class ReflectUtil {

    public String getPropertyType(Object obj, String property) {
        return Reflect.on(obj).field(property).type().getName();
    }

    @SneakyThrows
    public boolean isType(Object obj, String property, String type) {
        var clazz = getType(obj, property);

        if (clazz.isPrimitive()) {
            clazz = Primitives.wrap(clazz);
        }

        return Class.forName(type).isAssignableFrom(clazz);
    }

    public Class<?> getType(Object obj, String property) {
        return Reflect.on(obj).field(property).type();
    }

    public Object[] getEnumConstants(Object obj, String property) {
        val clazz = Reflect.on(obj).field(property).type();

        val constants = clazz.getEnumConstants();

        return constants != null ? constants : new Object[0];
    }
}
