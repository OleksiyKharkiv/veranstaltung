package com.example.veranstaltung.service;

import com.example.veranstaltung.entity.Veranstaltung;
import com.example.veranstaltung.repository.VeranstaltungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeranstaltungService {

    @Autowired
    private VeranstaltungRepository veranstaltungRepository;

    public List<Veranstaltung> findAll() {
        return veranstaltungRepository.findAll();
    }

    public Optional<Veranstaltung> findById(Long id) {
        return veranstaltungRepository.findById(id);
    }

    public Veranstaltung save(Veranstaltung veranstaltung) {
        return veranstaltungRepository.save(veranstaltung);
    }

    public void deleteById(Long id) {
        veranstaltungRepository.deleteById(id);
    }

    public Veranstaltung update(Veranstaltung veranstaltung) {
        if (veranstaltungRepository.existsById(veranstaltung.getId())) {
            return veranstaltungRepository.save(veranstaltung);
        }
        return null;
    }
}
