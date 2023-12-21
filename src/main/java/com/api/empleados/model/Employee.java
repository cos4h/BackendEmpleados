package com.api.empleados.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "charge", length = 30, nullable = false)
    private String charge;

    @Column(name = "dateEntry", length = 15, nullable = false)
    private String dateEntry;

    @Column(name = "dateBirth", length = 15, nullable = false)
    private String dateBirth;
}
