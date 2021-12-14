package cz.vsb.bed0152.jat.flightreservation.flightreservation.entity;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Passenger extends Person implements Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
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
