package com.BusManagementSystem.bms.controllers;

import com.BusManagementSystem.bms.models.dtos.TicketDto;
import com.BusManagementSystem.bms.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<TicketDto> getAllTickets(){
        return null;
    }
}
