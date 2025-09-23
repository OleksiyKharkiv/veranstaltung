package com.example.veranstaltung.repository;

import com.example.veranstaltung.entity.Buchung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuchungRepository extends JpaRepository<Buchung, Long> {
}
