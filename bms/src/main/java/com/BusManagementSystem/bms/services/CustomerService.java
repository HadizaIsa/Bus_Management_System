package com.BusManagementSystem.bms.services;

import com.BusManagementSystem.bms.entities.Customer;
import com.BusManagementSystem.bms.exceptions.EntityAlreadyExistsException;
import com.BusManagementSystem.bms.models.requests.CreateCustomerRequest;
import com.BusManagementSystem.bms.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(CreateCustomerRequest customerRequest){
//        check if customer exists
        if (customerExists(customerRequest.getEmail())){
            throw new EntityAlreadyExistsException(
                String.format("Customer with email '%s' already exists", customerRequest.getEmail())
            );
        }
        Customer customer = buildCustomer(customerRequest);
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer updateCustomer(CreateCustomerRequest request){
        Customer customer = buildCustomer(request);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer =findById(id);
        customerRepository.delete(customer);
    }

    private Customer buildCustomer(CreateCustomerRequest request) {
        return Customer.builder()
            .first_name(request.getFirst_name())
            .last_name(request.getLast_name())
            .email(request.getEmail())
            .address(request.getAddress())
            .phone(request.getPhone())
            .password(request.getPassword())
            .build();
    }

    private boolean customerExists(String email) {
        return customerRepository.findByEmail(email).isPresent();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer doesn't exists")
                );
    }


}
