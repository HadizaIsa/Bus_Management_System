package com.BusManagementSystem.bms.controllers;

import com.BusManagementSystem.bms.models.dtos.CustomerDto;
import com.BusManagementSystem.bms.models.mappers.CustomerDtoMapper;
import com.BusManagementSystem.bms.models.requests.CreateCustomerRequest;
import com.BusManagementSystem.bms.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    private CustomerDtoMapper customerDtoMapper;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody
            CreateCustomerRequest customerRequest){
        return new ResponseEntity<>(
                customerDtoMapper.mapToDto(customerService.createCustomer(customerRequest)),
                        HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(
                customerDtoMapper.mapToDtos(customerService.getAllCustomers())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                customerDtoMapper.mapToDto(customerService.findById(id))
        );

    }
    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long id,
             @RequestBody CreateCustomerRequest customerRequest){
        return ResponseEntity.ok(
                customerDtoMapper.mapToDto(customerService.updateCustomer(customerRequest))
        );
    }
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }

    public ResponseEntity<CustomerDto> searchCustomer(@PathVariable("id") Long id){
        return null;
    }

}
