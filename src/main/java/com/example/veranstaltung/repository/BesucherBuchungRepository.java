package com.example.veranstaltung.repository;

import com.example.veranstaltung.entity.BesucherBuchung;
import com.example.veranstaltung.entity.BesucherBuchungId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BesucherBuchungRepository
        extends JpaRepository<BesucherBuchung, BesucherBuchungId> {


    List<BesucherBuchung> findById_BesucherId(Long besucherId);
    List<BesucherBuchung> findById_BuchungId(Long buchungId);


    @Modifying
    @Query("delete from BesucherBuchung b where b.id.buchungId = :buchId")
    void deleteByBuchungId(@Param("buchId") Long buchungId);
}