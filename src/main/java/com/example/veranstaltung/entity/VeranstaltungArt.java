package com.example.veranstaltung.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veranstaltung_art")
public class VeranstaltungArt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veranstaltung_art_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "bezeichnung", nullable = false)
    private String bezeichnung;

    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Veranstaltung> veranstaltungen;
}
