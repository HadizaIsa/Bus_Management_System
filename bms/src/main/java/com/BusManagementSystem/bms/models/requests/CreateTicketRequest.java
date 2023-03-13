package com.BusManagementSystem.bms.models.requests;

import com.BusManagementSystem.bms.entities.Customer;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateTicketRequest {

    private String ticketNumber;

    private double price;

    private Customer customer;

}
