package cz.vsb.bed0152.jat.flightreservation.flightreservation.entity;

import lombok.*;
import lombok.EqualsAndHashCode.Include;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Passenger extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Setter(value = AccessLevel.NONE)
    @Include
    private int id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Flight flight;

    @Column(nullable = false)
    private String seat;

    @Column(nullable = false)
    private boolean bag = false;

}
