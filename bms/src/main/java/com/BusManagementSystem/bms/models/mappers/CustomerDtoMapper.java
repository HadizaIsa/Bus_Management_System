package com.BusManagementSystem.bms.models.mappers;

import com.BusManagementSystem.bms.entities.Customer;
import com.BusManagementSystem.bms.models.dtos.CustomerDto;
import com.BusManagementSystem.bms.models.dtos.TicketDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class CustomerDtoMapper implements EntityMapper<Customer, CustomerDto>{

    @Override
    public List<CustomerDto> mapToDtos(List<Customer> customers) {
        return customers
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Override
    public List<Customer> mapToEntities(List<CustomerDto> customerDtos) {
        return customerDtos
            .stream()
            .map(this::mapToEntity)
            .collect(toList());
    }

    @Override
    public CustomerDto mapToDto(Customer customer) {
        if(customer == null) {
            return null;
        }
        return CustomerDto.builder()
            .first_name(customer.getFirst_name())
            .last_name(customer.getLast_name())
            .email(customer.getEmail())
            .phone(customer.getPhone())
            .password(customer.getPassword())
            .address(customer.getAddress())
            .build();
    }

    @Override
    public Customer mapToEntity(CustomerDto customerDto) {
        if(customerDto == null) {
            return null;
        }
        return Customer.builder()
            .first_name(customerDto.getFirst_name())
            .last_name(customerDto.getLast_name())
            .email(customerDto.getEmail())
            .phone(customerDto.getPhone())
            .password(customerDto.getPassword())
            .address(customerDto.getAddress())
            .build();
    }
}
