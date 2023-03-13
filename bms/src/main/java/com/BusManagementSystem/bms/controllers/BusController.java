package com.BusManagementSystem.bms.controllers;

import com.BusManagementSystem.bms.models.dtos.BusDto;
import com.BusManagementSystem.bms.models.mappers.BusDtoMapper;
import com.BusManagementSystem.bms.models.requests.CreateBusRequest;
import com.BusManagementSystem.bms.services.BusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buses")
@AllArgsConstructor
public class BusController {

    private static final String BUS_ID = "id";
    private final BusService busService;

    private final BusDtoMapper busDtoMapper;

    @PostMapping
    public ResponseEntity<BusDto> createBus(@RequestBody CreateBusRequest request){
       return new ResponseEntity<>(busDtoMapper.mapToDto(busService.createBus(request))
               , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDto> getBus(@PathVariable(BUS_ID) Long id){
        return ResponseEntity.ok(
                busDtoMapper.mapToDto(busService.findOne(id))
        );

    }

    @GetMapping
    public ResponseEntity<List<BusDto>> getAllBuses(){
        return ResponseEntity.ok(
                busDtoMapper.mapToDtos(busService.getAllBuses())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusDto> updateBus(@RequestBody CreateBusRequest request){
        return ResponseEntity.ok(
                busDtoMapper.mapToDto(busService.updateBus(request))
        );

    }
    @GetMapping("capacity/{capacity}")
//    public ResponseEntity<List<BusDto>> getByCapacity(@RequestParam("capacity") Integer capacity){
    public ResponseEntity<List<BusDto>> getByCapacity(@PathVariable("capacity") Integer capacity){
        return ResponseEntity.ok(
                busDtoMapper.mapToDtos(busService.getBusByCapacity(capacity))
        );
    }
//    @GetMapping("/model")
//    public ResponseEntity<BusDto> getByModel(@PathVariable("model") String model){
//        BusDto busDto = busService.getBusByModel(model)
//                .orElseThrow(() -> new EntityNotFoundException("Bus not found"))
//
//        return busDtoMapper.mapToDto(busDto)
//        );
//    }

    @GetMapping("/amenities/{amenity}")
    public ResponseEntity<List<BusDto>> getBusesByAmenity(@PathVariable("amenity") String amenity){
        return ResponseEntity.ok(
                busDtoMapper.mapToDtos(busService.getBusesByAmenity(amenity))
        );

    }

//    @GetMapping("/buses-with-schedule")
//    public ResponseEntity<List<BusDto>> getAllBusesWithSchedule(LocalDate startDate, LocalDate endDate){
//        return ResponseEntity.ok(
//                busDtoMapper.mapToDtos(busService.getBusesWithSchedule(startDate, endDate))
//        );
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBus( @PathVariable(BUS_ID) Long id){
       busService.deleteBus(id);

       return new ResponseEntity<>(
               HttpStatus.NO_CONTENT
       );

    }

//    @/PostMapping("/{id}/schedules")


}
