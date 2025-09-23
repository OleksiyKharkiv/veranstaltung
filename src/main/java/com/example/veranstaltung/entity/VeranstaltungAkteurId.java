package com.example.veranstaltung.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class VeranstaltungAkteurId implements Serializable {

    private Long veranstaltungId;
    private Long akteurId;
}
