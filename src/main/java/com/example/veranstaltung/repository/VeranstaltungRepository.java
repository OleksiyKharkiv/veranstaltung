package com.example.veranstaltung.repository;

import com.example.veranstaltung.entity.Veranstaltung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeranstaltungRepository extends JpaRepository<Veranstaltung, Long> {
}
