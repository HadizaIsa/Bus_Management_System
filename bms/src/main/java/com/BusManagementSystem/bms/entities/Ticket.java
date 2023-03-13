package com.BusManagementSystem.bms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketNumber;

    private double price;

    @OneToOne
    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "bookings_id")
//    private Bookings bookings;

}
