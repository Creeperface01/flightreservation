package cz.vsb.bed0152.jat.flightreservation.flightreservation.util;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {

    @Getter
    private SessionFactory sessionFactory = buildSessionFactory();

    private SessionFactory buildSessionFactory() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (ExceptionInInitializerError exceptionObj) {
            exceptionObj.printStackTrace();
        }

        return sessionFactory;
    }
}
