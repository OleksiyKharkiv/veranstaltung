package com.example.veranstaltung.controller;

import com.example.veranstaltung.entity.Veranstaltung;
import com.example.veranstaltung.service.VeranstaltungService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veranstaltungen")
public class VeranstaltungController {

    private final VeranstaltungService veranstaltungService;

    public VeranstaltungController(VeranstaltungService veranstaltungService) {
        this.veranstaltungService = veranstaltungService;
    }

    @GetMapping
    public ResponseEntity<List<Veranstaltung>> getAllVeranstaltungen() {
        return ResponseEntity.ok(veranstaltungService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veranstaltung> getVeranstaltungById(@PathVariable Long id) {
        return veranstaltungService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veranstaltung> createVeranstaltung(@RequestBody Veranstaltung veranstaltung) {
        return ResponseEntity.ok(veranstaltungService.save(veranstaltung));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veranstaltung> updateVeranstaltung(@PathVariable Long id, @RequestBody Veranstaltung veranstaltung) {
        return veranstaltungService.update(id, veranstaltung)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeranstaltung(@PathVariable Long id) {
        if (veranstaltungService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
