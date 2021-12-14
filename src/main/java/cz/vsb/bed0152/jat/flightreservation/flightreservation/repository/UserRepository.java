package cz.vsb.bed0152.jat.flightreservation.flightreservation.repository;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.entity.User;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
@ManagedBean
public class UserRepository extends AbstractRepository<User> {

    public UserRepository() {
        super(User.class);
    }
}
