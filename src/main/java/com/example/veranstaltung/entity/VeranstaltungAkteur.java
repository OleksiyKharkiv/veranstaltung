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

    @MapsId("veranstaltungId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veranstaltung_id", nullable = false)
    private Veranstaltung veranstaltung;

    @MapsId("akteurId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "akteur_id", nullable = false)
    private Akteur akteur;
}
