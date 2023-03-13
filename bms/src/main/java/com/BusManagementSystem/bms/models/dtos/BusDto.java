package com.BusManagementSystem.bms.models.dtos;

import com.BusManagementSystem.bms.entities.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BusDto {
    private String model;

    private int capacity;

    private List<String> amenities;

    private List<Schedule> schedules;
}
