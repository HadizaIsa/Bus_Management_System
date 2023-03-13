package com.BusManagementSystem.bms.models.requests;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateCustomerRequest {

    private String first_name;

    private String last_name;

    private String email;

    private String phone;

//    private List<Bookings> bookings;

    private String password;

    private String address;
}
