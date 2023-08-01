package com.example.SunbaseDataAssignment.Repositories;

import com.example.SunbaseDataAssignment.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
