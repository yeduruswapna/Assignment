package com.example.SunbaseDataAssignment.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name= "Customer_List")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String street;
    private String address;
    private String city;
    private String state;
    @Column(unique = true)
    private String email;
    private String phone;
}
