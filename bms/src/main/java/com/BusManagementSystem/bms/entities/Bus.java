package com.BusManagementSystem.bms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Bus {

    @Id
    @Column(name = "bus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "bus_id_sequence"
    )
    @SequenceGenerator(
            name = "bus_id",
            sequenceName = "bus_id_sequence"
    )
    private Long id;

    private String model;

    private Integer capacity;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "amenities")
    private List<String> amenities;

//    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
//    private List<Schedule> schedules;
}
