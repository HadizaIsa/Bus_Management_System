package com.BusManagementSystem.bms.models.mappers;

import com.BusManagementSystem.bms.entities.Schedule;
import com.BusManagementSystem.bms.models.dtos.ScheduleDto;
import com.BusManagementSystem.bms.models.dtos.TicketDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class ScheduleDtoMapper implements EntityMapper<Schedule, ScheduleDto> {
    @Override
    public List<ScheduleDto> mapToDtos(List<Schedule> schedules) {
        return schedules
            .stream()
            .map(this::mapToDto)
            .collect(toList());
    }

    @Override
    public List<Schedule> mapToEntities(List<ScheduleDto> scheduleDtos) {
        return scheduleDtos
            .stream()
            .map(this::mapToEntity)
            .collect(toList());
    }

    @Override
    public ScheduleDto mapToDto(Schedule schedule) {
        if (schedule == null) {
            return null;
        }
        return ScheduleDto.builder()
            .bus(schedule.getBus())
            .arrivalTime(schedule.getArrivalTime())
            .departureTime(schedule.getDepartureTime())
            .build();
    }

    @Override
    public Schedule mapToEntity(ScheduleDto scheduleDto) {
        if(scheduleDto == null){
        return null;
    }
        return Schedule.builder()
            .bus(scheduleDto.getBus())
            .arrivalTime(scheduleDto.getArrivalTime())
            .departureTime(scheduleDto.getDepartureTime())
            .build();
    }
}
