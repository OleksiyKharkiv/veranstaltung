package com.example.veranstaltung.controller;

import com.example.veranstaltung.entity.Akteur;
import com.example.veranstaltung.service.AkteurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/akteure")
public class AkteurController {

    private final AkteurService akteurService;

    public AkteurController(AkteurService akteurService) {
        this.akteurService = akteurService;
    }

    @GetMapping
    public ResponseEntity<List<Akteur>> getAllAkteure() {
        return ResponseEntity.ok(akteurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Akteur> getAkteurById(@PathVariable Long id) {
        return akteurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Akteur> createAkteur(@RequestBody Akteur akteur) {
        return new ResponseEntity<>(akteurService.save(akteur), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Akteur> updateAkteur(@PathVariable Long id, @RequestBody Akteur akteur) {
        return akteurService.findById(id)
                .map(existingAkteur -> {
                    akteur.setId(id);
                    return ResponseEntity.ok(akteurService.save(akteur));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAkteur(@PathVariable Long id) {
        return akteurService.findById(id)
                .map(akteur -> {
                    akteurService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
