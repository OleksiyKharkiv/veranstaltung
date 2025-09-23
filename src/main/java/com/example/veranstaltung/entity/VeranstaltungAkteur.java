package com.example.veranstaltung.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veranstaltung_akteur")
public class VeranstaltungAkteur {
    @EmbeddedId
    private VeranstaltungAkteurId id;

    @MapsId("veranstaltung_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Veranstaltung veranstaltung;

    @MapsId("akteur_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Akteur akteur;
}
