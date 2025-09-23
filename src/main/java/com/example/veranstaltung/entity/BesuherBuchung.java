package com.example.veranstaltung.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "besucher_buchung")
public class BesucherBuchung {
    @Embedded
    private BesucherBuchungId id;

    @MapsId("besucherId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "besucher_id", insertable = false, updatable = false)
    private Besucher besucher;

    @MapsId("buchungId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buchung_id", insertable = false, updatable = false)
    private Buchung buchung;

}
