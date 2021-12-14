package cz.vsb.bed0152.jat.flightreservation.flightreservation.entity;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "plane")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Plane implements Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Include
    private int id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String model;

    @Override
    public String getPartialIdentifier() {
        return code;
    }
}
