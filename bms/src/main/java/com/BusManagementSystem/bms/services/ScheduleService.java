package com.BusManagementSystem.bms.services;

import com.BusManagementSystem.bms.entities.Bus;
import com.BusManagementSystem.bms.entities.Schedule;
import com.BusManagementSystem.bms.models.requests.CreateScheduleRequest;
import com.BusManagementSystem.bms.repositories.BusRepository;
import com.BusManagementSystem.bms.repositories.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    private BusRepository busRepository;

    @Transactional
    public Schedule createSchedule(CreateScheduleRequest request){
        Bus bus =busRepository.findById(request.getBus().getId()).orElseThrow(EntityNotFoundException::new);
        Schedule schedule = buildSchedule(request, bus);
        return scheduleRepository.save(schedule);
    }

    public Schedule getSchedule(Long id){
        return scheduleRepository.findById(id)
         .orElseThrow(() -> new EntityNotFoundException("Schedule not found"));
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule updateSchedule(CreateScheduleRequest request) {
        Bus bus = busRepository.findById(request.getBus().getId())
            .orElseThrow(EntityNotFoundException::new);
        Schedule schedule = buildSchedule(request, bus);
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id){
        Schedule schedule = getSchedule(id);
        scheduleRepository.delete(schedule);
    }

//    private Schedule buildSchedule(CreateScheduleRequest request, Bus bus) {
//        Schedule schedule = Schedule.builder()
////        return Schedule.builder()
////          .bus(request.getBus())
//            .source(request.getSource())
//            .destination(request.getDestination())
//            .departureTime(request.getDepartureTime())
//            .arrivalTime(request.getArrivalTime())
//            .build();
//        schedule.setBus(bus);
//
//        return schedule;
//    }

    private Schedule buildSchedule(CreateScheduleRequest request, Bus bus){
        Schedule schedule = new Schedule();
        schedule.setSource(request.getSource());
        schedule.setDestination(request.getDestination());
        schedule.setDepartureTime(request.getDepartureTime());
        schedule.setArrivalTime(request.getArrivalTime());
        schedule.setBus(bus);
        return schedule;
    }

}
