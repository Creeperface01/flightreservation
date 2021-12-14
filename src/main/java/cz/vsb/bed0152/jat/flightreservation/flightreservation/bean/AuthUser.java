package cz.vsb.bed0152.jat.flightreservation.flightreservation.bean;

import at.favre.lib.crypto.bcrypt.BCrypt;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.User;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.util.BootstrapSeverity;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.util.Config;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.util.Extensions;
import cz.vsb.bed0152.jat.flightreservation.flightreservation.util.Maps;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import lombok.experimental.ExtensionMethod;
import lombok.val;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
    private transient User user;

    @PostConstruct
    private void init() {
        if (loggedUserId > 0) {
            this.user = entityManager.find(User.class, loggedUserId);
        }
    }

    public User login(String email, String password) {
        if (isLoggedIn()) {
            return this.user;
        }

        User user = entityManager.findOneBy(User.class, Maps.of(
                "email", email
        ));

        if (user != null) {
            val result = BCrypt.verifyer().verify(
                    password.toCharArray(),
                    user.getPassword()
            );

            if (result.verified) {
                loggedUserId = user.getId();
                flashBag.add("Byli jste úspěšně přihlášeni", BootstrapSeverity.SUCCESS);
                return (this.user = user);
            }
        }

        flashBag.add("Špatné uživatelské jméno nebo heslo", BootstrapSeverity.DANGER);
        return (this.user = null);
    }

    @Transactional
    public User register(User user) {
        user.setPassword(
                BCrypt.withDefaults().hashToString(
                        Config.BCRYPT_ROUNDS,
                        user.getPassword().toCharArray()
                )
        );

        entityManager.persist(user);
        entityManager.flush();

        entityManager.detach(user);

        flashBag.add("Registrace byla úspěšná", BootstrapSeverity.SUCCESS);
        return entityManager.find(User.class, user.getId());
    }

    public void logout() {
        this.user = null;
        this.loggedUserId = -1;

        flashBag.add("Byli jste úspěšně odhlášeni", BootstrapSeverity.SUCCESS);
    }

    public boolean isLoggedIn() {
        return user != null;
    }
}
