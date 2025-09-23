package com.example.veranstaltung.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Entity
NoArgsConstructor
@AllArgsConstructor
@Table(name = "veranstaltung")

public class Veranstaltung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "veranstaltung_id", nullable = false, updateble = false)
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
