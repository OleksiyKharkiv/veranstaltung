package com.example.veranstaltung.service;

import com.example.veranstaltung.entity.Akteur;
import com.example.veranstaltung.repository.AkteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AkteurService {

    private final AkteurRepository akteurRepository;

    @Autowired
    public AkteurService(AkteurRepository akteurRepository) {
        this.akteurRepository = akteurRepository;
    }

    public List<Akteur> findAll() {
        return akteurRepository.findAll();
    }

    public Optional<Akteur> findById(Long id) {
        return akteurRepository.findById(id);
    }

    public Akteur save(Akteur akteur) {
        return akteurRepository.save(akteur);
    }

    public void deleteById(Long id) {
        akteurRepository.deleteById(id);
    }

    public Akteur update(Long id, Akteur akteur) {
        if (akteurRepository.existsById(id)) {
            akteur.setId(id);
            return akteurRepository.save(akteur);
        }
        return null;
    }
}
