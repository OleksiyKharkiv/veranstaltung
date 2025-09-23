package com.example.veranstaltung.repository;

import com.example.veranstaltung.entity.Besucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BesucherRepository extends JpaRepository<Besucher, Long> {
}
