package cz.vsb.bed0152.jat.flightreservation.flightreservation.entity;

import lombok.*;
import lombok.EqualsAndHashCode.Include;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "plane")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Setter(value = AccessLevel.NONE)
    @Include
    private int id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String model;

}
