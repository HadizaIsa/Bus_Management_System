package com.BusManagementSystem.bms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

   private String firstName;

   private String lastName;

   private String email;

   private String phoneNumber;

//   private Status driverStatus;

    private Date createdAt;

    private Date updatedAt;
}
