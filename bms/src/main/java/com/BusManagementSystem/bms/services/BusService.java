package com.BusManagementSystem.bms.services;

import com.BusManagementSystem.bms.entities.Bus;
import com.BusManagementSystem.bms.exceptions.EntityAlreadyExistsException;
import com.BusManagementSystem.bms.models.requests.CreateBusRequest;
import com.BusManagementSystem.bms.repositories.BusRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BusService {

    private final BusRepository busRepository;

    public Bus createBus(CreateBusRequest busRequest){
//        check if a bus exists
        if(isBusExists(busRequest.getModel())){
            throw new EntityAlreadyExistsException(
                    String.format("Bus with model '%s' already exists ", busRequest.getModel())
            );
        }
//        create bus
        Bus bus = buildBusEntity(busRequest);
        return busRepository.save(bus);

    }

    @Transactional
    public Bus findOne(Long id){
        return busRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Bus not found"));
    }
    @Transactional
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Bus updateBus(CreateBusRequest request) {
        return busRepository.save(buildBusEntity(request));
    }

    public Optional<Bus> getBusByModel(String model){
        return busRepository.findByModel(model);
    }

    public List<Bus> getBusByCapacity(Integer capacity){
        return busRepository.findByCapacity(capacity);
    }

    public List<Bus> getBusesByAmenity(String amenity){
        return busRepository.findByAmenitiesContaining(amenity);
    }

//    public List<Bus> getBusesWithSchedule(LocalDate startDate, LocalDate endDate){
//        return busRepository.findBySchedulesBetween(startDate, endDate);
//    }
    public void deleteBus(Long id){
        Bus bus = findOne(id);
        busRepository.delete(bus);
    }

    private Bus buildBusEntity(CreateBusRequest request) {
        return Bus.builder()
            .model(request.getModel())
            .capacity(request.getCapacity())
            .amenities(request.getAmenities())
            .build();
    }

    private boolean isBusExists(String model){
        return busRepository.findByModel(model).isPresent();
    }

}
