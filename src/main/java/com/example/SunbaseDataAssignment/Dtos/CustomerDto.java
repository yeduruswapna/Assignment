package com.example.SunbaseDataAssignment.Dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String street;
    private String address;
    private String city;
    private String state;
    private String email;
    private String phone;
}
