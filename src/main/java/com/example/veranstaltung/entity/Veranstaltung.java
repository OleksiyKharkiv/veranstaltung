package com.example.veranstaltung.entity;


import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veranstaltung")
public class Veranstaltung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "veranstaltung_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Override
    public String toString() {
        return "Veranstaltung{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
