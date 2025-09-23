package com.example.veranstaltung.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ort")
public class Ort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plz", nullable = false)
    private Long plz;

    @Column(name = "name", nullable = false)
    private String name;

@OneToMany(mappedBy = "plz", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Location> locations;
}
