package cz.vsb.bed0152.jat.flightreservation.flightreservation.entity;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "flight")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Flight implements Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
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

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Plane plane;

    @OneToMany(mappedBy = "flight", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
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

    @Override
    public String getPartialIdentifier() {
        return departure.toString();
    }
}
