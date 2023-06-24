package com.infoWare.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private long phone;
    private String email;

    @OneToOne
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_emergency_contact_id",referencedColumnName = "id")
    private EmergencyContact primaryEmergencyContact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secondary_emergency_contact_id", referencedColumnName = "id")
    private EmergencyContact secondaryEmergencyContact;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private Job job;

    public Employee(String name, long phone, String email, Address address, EmergencyContact primaryEmergencyContact, EmergencyContact secondaryEmergencyContact, Job job) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.primaryEmergencyContact = primaryEmergencyContact;
        this.secondaryEmergencyContact = secondaryEmergencyContact;
        this.job = job;
    }
}
