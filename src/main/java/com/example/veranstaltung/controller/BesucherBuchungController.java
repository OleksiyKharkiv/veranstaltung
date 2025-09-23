package com.example.veranstaltung.controller;

import com.example.veranstaltung.dto.BesucherBuchungDTO;
import com.example.veranstaltung.service.BesucherBuchungService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/besucher-buchung")
@RequiredArgsConstructor
public class BesucherBuchungController {

    private final BesucherBuchungService service;

    /* CREATE / UPDATE (upsert) */
    @PostMapping
    public ResponseEntity<BesucherBuchungDTO> createOrUpdate(
            @Valid @RequestBody BesucherBuchungDTO dto) {
        BesucherBuchungDTO saved = service.save(dto);
        URI uri = URI.create("/api/besucher-buchung/" +
                saved.besucherId() + "/" + saved.buchungId());
        return ResponseEntity.created(uri).body(saved);
    }

    /* READ */
    @GetMapping(params = "besucherId")
    public List<BesucherBuchungDTO> getByBesucher(@RequestParam Long besucherId) {
        return service.findByBesucher(besucherId);
    }

    @GetMapping(params = "buchungId")
    public List<BesucherBuchungDTO> getByBuchung(@RequestParam Long buchungId) {
        return service.findByBuchung(buchungId);
    }

    /* DELETE */
    @DeleteMapping("/{besucherId}/{buchungId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long besucherId,
            @PathVariable Long buchungId) {
        service.delete(besucherId, buchungId);
        return ResponseEntity.noContent().build();
    }
}