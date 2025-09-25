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
@Table(name = "besucher")
public class Besucher {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "besucher_id", nullable = false, updatable = false)
    private Long besucherId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "besucher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BesucherBuchung> besucherBuchungList;
}
