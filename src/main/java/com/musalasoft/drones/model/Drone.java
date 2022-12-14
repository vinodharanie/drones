package com.musalasoft.drones.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "drones")
@Getter
@Setter
@ToString
public class Drone {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    @OneToOne
    @JoinColumn(name="model_id")
    private Model model;

    @Column(name = "weight_limit")
    private BigDecimal weightLimit;

    @Column(name = "battery_capacity")
    private BigDecimal batteryCapacity;

    @Column(name = "state")
    private int state;

    @ManyToMany
    @JoinTable(
            name = "drone_medication",
            joinColumns = @JoinColumn(name = "drone_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id"))
    List<Medication> medications;

}
