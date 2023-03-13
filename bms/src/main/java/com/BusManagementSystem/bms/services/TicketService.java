package com.BusManagementSystem.bms.services;

import com.BusManagementSystem.bms.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    private TicketRepository ticketRepository;

}
