package com.example.veranstaltung.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veranstaltung")
public class Veranstaltung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veranstaltung_id", nullable = false, updatable = false)
    private Long veranstaltungId;

    @Column(name = "name", nullable = false)
    private String name;

    private Date datum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veranstaltung_art_id", nullable = false)
    private VeranstaltungArt art;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
}
