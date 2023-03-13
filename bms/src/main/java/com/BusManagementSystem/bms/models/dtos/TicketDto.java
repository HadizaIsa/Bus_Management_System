package com.BusManagementSystem.bms.models.dtos;

import com.BusManagementSystem.bms.entities.Customer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TicketDto {

    private String ticketNumber;

    private double price;

    private Customer customer;

//    private Bookings bookings;
}
