package com.example.SunbaseDataAssignment.Services;


import com.example.SunbaseDataAssignment.Dtos.CustomerDto;
import com.example.SunbaseDataAssignment.Exceptions.CustomerNotFoundException;
import com.example.SunbaseDataAssignment.Exceptions.MissingDataException;
import com.example.SunbaseDataAssignment.Models.Customer;
import com.example.SunbaseDataAssignment.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(CustomerDto customerDto) throws MissingDataException {
        if(customerDto.getFirstName() == null || customerDto.getLastName() == null) {
            throw new MissingDataException("First Name or Last Name is missing");
        }

        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setStreet(customerDto.getStreet());
        customer.setAddress(customerDto.getAddress());
        customer.setCity(customerDto.getCity());
        customer.setState(customerDto.getState());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());

        customerRepository.save(customer);
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos= new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setFirstName(customer.getFirstName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setStreet(customer.getStreet());
            customerDto.setAddress(customer.getAddress());
            customerDto.setCity(customer.getCity());
            customerDto.setState(customer.getState());
            customerDto.setEmail(customer.getEmail());
            customerDto.setPhone(customer.getPhone());

            customerDtos.add(customerDto);
        }

        return customerDtos;
    }

    public void deleteCustomer(String uuid) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(uuid).orElse(null);
        if (customer == null) {
            throw new CustomerNotFoundException("UUID not found");
        }

        customerRepository.delete(customer);
    }

    public void updateCustomer(String uuid, CustomerDto customerDto) throws CustomerNotFoundException, MissingDataException {
        Customer customer = customerRepository.findById(uuid).orElse(null);
        if (customer == null) {
            throw new CustomerNotFoundException("UUID not found");
        }

        if (customerDto.getFirstName() == null || customerDto.getLastName() == null) {
            throw new MissingDataException("First Name or Last Name is missing");
        }

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setStreet(customerDto.getStreet());
        customer.setAddress(customerDto.getAddress());
        customer.setCity(customerDto.getCity());
        customer.setState(customerDto.getState());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());

        customerRepository.save(customer);
    }
}
