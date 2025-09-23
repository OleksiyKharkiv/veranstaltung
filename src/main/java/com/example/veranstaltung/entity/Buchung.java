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
@Table(name = "buchung")
public class Buchung {
    @Id
    @Column(name = "buchung_id", nullable = false, updatable = false)
    private Long buchungId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veranstaltung_id", nullable = false)
    private Veranstaltung veranstaltung;
}
