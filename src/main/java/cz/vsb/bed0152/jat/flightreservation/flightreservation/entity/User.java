package cz.vsb.bed0152.jat.flightreservation.flightreservation.entity;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.component.user.Role;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User extends Person implements Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Include
    private int id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Override
    public String getPartialIdentifier() {
        return getName() + " " + getSurname();
    }
}
