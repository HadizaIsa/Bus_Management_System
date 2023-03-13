package com.BusManagementSystem.bms.models.mappers;

import com.BusManagementSystem.bms.entities.Bus;
import com.BusManagementSystem.bms.models.dtos.BusDto;
import com.BusManagementSystem.bms.models.dtos.TicketDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class BusDtoMapper implements  EntityMapper<Bus, BusDto> {

    @Override
    public List<BusDto> mapToDtos(List<Bus> buses) {
        return buses
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Override
    public List<Bus> mapToEntities(List<BusDto> busDtos) {
        return busDtos
                .stream()
                .map(this::mapToEntity)
                .collect(toList());
    }

    @Override
    public BusDto mapToDto(Bus bus) {
        if (bus == null) {
            return null;
        }
        return BusDto.builder()
                .model(bus.getModel())
                .capacity(bus.getCapacity())
                .amenities(bus.getAmenities())
                .build();
    }

    @Override
    public Bus mapToEntity(BusDto busDto) {
        if (busDto == null){
            return null;
    }
    return Bus.builder()
        .model(busDto.getModel())
        .capacity(busDto.getCapacity())
        .amenities(busDto.getAmenities())
        .build();
    }
}
