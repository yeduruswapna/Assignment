package com.example.SunbaseDataAssignment.Controllers;

import com.example.SunbaseDataAssignment.Dtos.CustomerDto;
import com.example.SunbaseDataAssignment.Exceptions.CustomerNotFoundException;
import com.example.SunbaseDataAssignment.Exceptions.MissingDataException;
import com.example.SunbaseDataAssignment.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDto customerDto) {
        try {
            customerService.createCustomer(customerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created");
        } catch (MissingDataException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("First Name or Last Name is missing");
        }
    }

    @GetMapping("/get_customer_list")
    public ResponseEntity<List<CustomerDto>> getCustomerList() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam String uuid) {
        try {
            customerService.deleteCustomer(uuid);
            return ResponseEntity.ok("Successfully deleted");
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UUID not found");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestParam String uuid, @RequestBody CustomerDto customerDto) {
        try {
            customerService.updateCustomer(uuid, customerDto);
            return ResponseEntity.ok("Successfully Updated");
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UUID not found");
        } catch (MissingDataException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("First Name or Last Name is missing");
        }
    }
}