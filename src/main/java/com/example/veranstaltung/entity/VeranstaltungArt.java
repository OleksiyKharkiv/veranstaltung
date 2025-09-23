package com.example.veranstaltung.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veranstaltung_art")
public class VeranstaltungArt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "veranstaltung_art_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "bezeichnung", nullable = false)
    private String bezeichnung;
}
