package com.BusManagementSystem.bms.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateBusRequest {

    private  String model;

    private Integer capacity;

    private List<String> amenities;

//    private List<Schedule> schedules;
}
