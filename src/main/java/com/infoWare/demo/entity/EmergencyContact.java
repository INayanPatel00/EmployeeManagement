package com.infoWare.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table
public class EmergencyContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private long phone;
    private String relation;

    public EmergencyContact(String name, long phone, String relation) {
        this.name = name;
        this.phone = phone;
        this.relation = relation;
    }

    public EmergencyContact(int id, String name, long phone, String relation) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.relation = relation;
    }
}
