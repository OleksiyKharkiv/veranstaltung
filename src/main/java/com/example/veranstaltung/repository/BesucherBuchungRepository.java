package com.example.veranstaltung.repository;

import com.example.veranstaltung.entity.BesucherBuchung;
import com.example.veranstaltung.entity.BesucherBuchungId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BesucherBuchungRepository
        extends JpaRepository<BesucherBuchung, BesucherBuchungId> {

    List<BesucherBuchung> findByBesucherId(Long besucherId);
    List<BesucherBuchung> findByBuchungId(Long buchungId);

    void deleteByBuchungId(Long buchungId);
}