package com.example.veranstaltung.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class BesucherBuchungId {
    private Long besucherId;
    private Long buchungId;
}
