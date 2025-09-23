package com.example.veranstaltung.controller;

import com.example.veranstaltung.entity.Besucher;
import com.example.veranstaltung.service.BesucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/besucher")
public class BesucherController {

    @Autowired
    private BesucherService besucherService;

    @GetMapping
    public ResponseEntity<List<Besucher>> getAllBesucher() {
        return new ResponseEntity<>(besucherService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Besucher> getBesucherById(@PathVariable Long id) {
        return besucherService.findById(id)
                .map(besucher -> new ResponseEntity<>(besucher, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Besucher> createBesucher(@RequestBody Besucher besucher) {
        return new ResponseEntity<>(besucherService.save(besucher), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Besucher> updateBesucher(@PathVariable Long id, @RequestBody Besucher besucher) {
        return besucherService.findById(id)
                .map(existingBesucher -> {
                    besucher.setBesucherId(id);
                    return new ResponseEntity<>(besucherService.save(besucher), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBesucher(@PathVariable Long id) {
        return besucherService.findById(id)
                .map(besucher -> {
                    besucherService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
