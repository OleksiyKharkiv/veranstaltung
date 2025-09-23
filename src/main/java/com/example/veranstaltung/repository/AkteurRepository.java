package com.example.veranstaltung.repository;

import com.example.veranstaltung.entity.Akteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AkteurRepository extends JpaRepository<Akteur, Long> {
}
