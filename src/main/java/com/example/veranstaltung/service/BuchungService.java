package com.example.veranstaltung.service;

import com.example.veranstaltung.entity.Buchung;
import com.example.veranstaltung.repository.BuchungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BuchungService {

    private final BuchungRepository buchungRepository;

    @Autowired
    public BuchungService(BuchungRepository buchungRepository) {
        this.buchungRepository = buchungRepository;
    }

    public List<Buchung> getAll() {
        return buchungRepository.findAll();
    }

    public Optional<Buchung> getById(Long id) {
        return buchungRepository.findById(id);
    }

    public Buchung save(Buchung buchung) {
        return buchungRepository.save(buchung);
    }

    public void delete(Long id) {
        buchungRepository.deleteById(id);
    }
}
