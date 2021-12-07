package cz.vsb.bed0152.jat.flightreservation.flightreservation.bean;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.User;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.util.BootstrapSeverity;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.util.Extensions;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.util.Maps;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import lombok.experimental.ExtensionMethod;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped
@Named
@Accessors
@ExtensionMethod({Extensions.class})
public class AuthUser implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private FlashBag flashBag;

    private int loggedUserId = -1;

    @Delegate
    private User user;

    @PostConstruct
    private void init() {
        if (loggedUserId > 0) {
            this.user = entityManager.find(User.class, loggedUserId);
        }
    }

    public User login(String email, String password) {
        User user = entityManager.findOneBy(User.class, Maps.of(
                "password", password,
                "email", email
        ));

        if (user != null) {
            loggedUserId = user.getId();
            flashBag.add("Registrace byla úspěšná", BootstrapSeverity.SUCCESS);
        } else {
            flashBag.add("Špatné uživatelské jméno nebo heslo", BootstrapSeverity.DANGER);
        }

        return (this.user = user);
    }

    public User register(User user) {
        entityManager.persist(user);
        entityManager.flush();

        entityManager.detach(user);

        flashBag.add("Registrace byla úspěšná", BootstrapSeverity.SUCCESS);
        return entityManager.find(User.class, user.getId());
    }

    public void logout() {
        this.user = null;
        this.loggedUserId = -1;
    }

    public boolean isLoggedIn() {
        return user != null;
    }
}
