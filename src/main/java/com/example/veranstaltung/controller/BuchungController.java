package com.example.veranstaltung.controller;

import com.example.veranstaltung.entity.Buchung;
import com.example.veranstaltung.service.BuchungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buchungen")
public class BuchungController {

    private final BuchungService buchungService;

    @Autowired
    public BuchungController(BuchungService buchungService) {
        this.buchungService = buchungService;
    }

    @PostMapping
    public ResponseEntity<Buchung> create(@RequestBody Buchung buchung) {
        Buchung newBuchung = buchungService.save(buchung);
        return new ResponseEntity<>(newBuchung, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Buchung>> getAll() {
        List<Buchung> buchungen = buchungService.getAll();
        return new ResponseEntity<>(buchungen, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buchung> getById(@PathVariable Long id) {
        return buchungService.getById(id)
                .map(buchung -> new ResponseEntity<>(buchung, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buchung> update(@PathVariable Long id, @RequestBody Buchung buchung) {
        return buchungService.getById(id)
                .map(existingBuchung -> {
                    buchung.setBuchungId(id);
                    return new ResponseEntity<>(buchungService.save(buchung), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return buchungService.getById(id)
                .map(buchung -> {
                    buchungService.delete(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
