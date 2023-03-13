package com.BusManagementSystem.bms.controllers;

import com.BusManagementSystem.bms.entities.Bus;
import com.BusManagementSystem.bms.models.dtos.ScheduleDto;
import com.BusManagementSystem.bms.models.mappers.ScheduleDtoMapper;
import com.BusManagementSystem.bms.models.requests.CreateScheduleRequest;
import com.BusManagementSystem.bms.services.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {

    private ScheduleService scheduleService;

    private ScheduleDtoMapper scheduleDtoMapper;

    @PostMapping
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody CreateScheduleRequest request){
        return ResponseEntity.ok(
               scheduleDtoMapper.mapToDto(scheduleService.createSchedule(request))
        );
    }

    @GetMapping
    public ResponseEntity<List<ScheduleDto>> getAllSchedules(){
        return ResponseEntity.ok(
                scheduleDtoMapper.mapToDtos(scheduleService.getAllSchedules())
        );
    }

    @GetMapping("/{schedule-id}")
    public ResponseEntity<ScheduleDto> getSchedule(@PathVariable Long id){
        return ResponseEntity.ok(
                scheduleDtoMapper.mapToDto(scheduleService.getSchedule(id))
        );
    }

    @PutMapping("/{schedule-id}")
    public ResponseEntity<ScheduleDto> updateSchedule(@PathVariable Long id, CreateScheduleRequest request){
        return ResponseEntity.ok(
                scheduleDtoMapper.mapToDto(scheduleService.updateSchedule(request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }

}
