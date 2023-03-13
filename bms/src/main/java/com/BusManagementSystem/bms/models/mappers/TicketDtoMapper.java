package com.BusManagementSystem.bms.models.mappers;

import com.BusManagementSystem.bms.entities.Ticket;
import com.BusManagementSystem.bms.models.dtos.TicketDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class TicketDtoMapper implements  EntityMapper<Ticket, TicketDto> {
    @Override
    public List<TicketDto> mapToDtos(List<Ticket> tickets) {
        return tickets
            .stream()
            .map(this::mapToDto)
            .collect(toList());
    }

    @Override
    public List<Ticket> mapToEntities(List<TicketDto> routeDtos) {
        return routeDtos
            .stream()
            .map(this::mapToEntity)
            .collect(toList());
    }

    @Override
    public TicketDto mapToDto(Ticket ticket) {
        if(ticket == null) {
            return null;
        }
        return TicketDto.builder()
            .ticketNumber(ticket.getTicketNumber())
            .price(ticket.getPrice())
            .customer(ticket.getCustomer())
            .build();
    }

    @Override
    public Ticket mapToEntity(TicketDto ticketDto) {
        if (ticketDto == null) {
            return null;
        }
        return Ticket.builder()
            .ticketNumber(ticketDto.getTicketNumber())
            .price(ticketDto.getPrice())
            .customer(ticketDto.getCustomer())
            .build();
    }
}
