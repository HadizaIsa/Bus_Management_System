package com.BusManagementSystem.bms.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerDto {

    private String first_name;

    private String last_name;

    private String email;

    private String phone;

//    private List<Bookings> bookings;

    private String password;

    private String address;

}
