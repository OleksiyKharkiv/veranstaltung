package com.example.veranstaltung.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "besucher_buchung")
public class BesucherBuchung {

    @EmbeddedId
    private BesucherBuchungId id;

    @MapsId("besucherId")          // говорим: это FK → Besucher
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "besucher_id", insertable = false, updatable = false)
    private Besucher besucher;

    @MapsId("buchungId")           // а это FK → Buchung
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "buchung_id", insertable = false, updatable = false)
    private Buchung buchung;

    private BigDecimal einzelPreis;
    private int ticketAnzahl;
    private LocalDate datum;
}