package com.example.veranstaltung.controller;

import com.example.veranstaltung.entity.BesucherBuchung;
import com.example.veranstaltung.service.BesucherBuchungService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buchungen")
@RequiredArgsConstructor
public class BesucherBuchungController {

    private final BesucherBuchungService besucherBuchungService;

    @PostMapping
    public ResponseEntity<BesucherBuchung> create(@RequestBody BesucherBuchung buchung) {
        return new ResponseEntity<>(besucherBuchungService.save(buchung), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BesucherBuchung>> getAll() {
        return ResponseEntity.ok(besucherBuchungService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BesucherBuchung> getById(@PathVariable Long id) {
        return besucherBuchungService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BesucherBuchung> updateBuchung(@PathVariable Long id, @RequestBody BesucherBuchung buchung) {
        return besucherBuchungService.findById(id)
                .map(existingBuchung -> ResponseEntity.ok(besucherBuchungService.save(buchung)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuchung(@PathVariable Long id) {
        return besucherBuchungService.findById(id)
                .map(buchung -> {
                    besucherBuchungService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
