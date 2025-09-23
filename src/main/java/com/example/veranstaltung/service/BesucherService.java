package com.example.veranstaltung.service;

import com.example.veranstaltung.entity.Akteur;
import com.example.veranstaltung.entity.Besucher;
import com.example.veranstaltung.repository.BesucherRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BesucherService {

    private final BesucherRepository besucherRepository;

    @Autowired
    public BesucherService(BesucherRepository besucherRepository) {
        this.besucherRepository = besucherRepository;
    }

    public List<Besucher> findAll() {
        return besucherRepository.findAll();
    }

    public Optional<Besucher> findById(Long id) {
        return besucherRepository.findById(id);
    }

    public Besucher save(Besucher besucher) {
        return besucherRepository.save(besucher);
    }

    public void deleteById(Long id) {
        besucherRepository.deleteById(id);
    }

    public Besucher update(Long id, Besucher besucher) {
        if (besucherRepository.existsById(id)) {
            besucher.setBesucherId(id);
            return besucherRepository.save(besucher);
        }
        return null;
    }
}
