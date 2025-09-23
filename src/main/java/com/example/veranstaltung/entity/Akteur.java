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
@Table(name = "akteur")
public class Akteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "akteur_id", nullable = false, updatable = false)
    private Long akteurId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "land", nullable = false)
    private String land;

    @OneToMany(mappedBy = "akteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VeranstaltungAkteur> veranstaltungAkteurList;

}
