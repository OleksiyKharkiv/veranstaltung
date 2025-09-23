package com.example.veranstaltung.entity;


import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veranstaltung_art_id", nullable = false)
    private VeranstaltungArt art;

    @Override
    public String toString() {
        return "Veranstaltung{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
