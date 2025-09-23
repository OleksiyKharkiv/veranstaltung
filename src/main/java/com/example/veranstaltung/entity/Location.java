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
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "location_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "plz", nullable = false)
private Ort olz;

@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Veranstaltung> veranstaltungen;

}
