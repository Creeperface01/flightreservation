package cz.vsb.bed0152.jat.flightreservation.flightreservation.entity;

import lombok.*;
import lombok.EqualsAndHashCode.Include;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "flight")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Setter(value = AccessLevel.NONE)
    @Include
    private int id;

    @Column(nullable = false)
    private Date departure;

    @Column(nullable = false)
    private Date arrival;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Plane plane;

    @OneToMany(mappedBy = "flight")
    private Set<Passenger> passengers;

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
    }

    public boolean hasPassenger(Passenger passenger) {
        return this.passengers.contains(passenger);
    }
}
