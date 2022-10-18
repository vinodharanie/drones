package com.musalasoft.drones.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.math.BigDecimal;

@Entity
@Table(name = "medications")
@Getter
@Setter
@ToString
public class Medication {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "code")
    private String code;


}
