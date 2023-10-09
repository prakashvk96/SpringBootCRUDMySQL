package com.practice.CrudOperation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private int flatNo;
    private String landmark;
    private String city;
    private String state;
}
