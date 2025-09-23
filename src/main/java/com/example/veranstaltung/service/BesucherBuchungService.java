package com.example.veranstaltung.service;

import com.example.veranstaltung.dto.BesucherBuchungDTO;
import com.example.veranstaltung.entity.BesucherBuchung;
import com.example.veranstaltung.entity.BesucherBuchungId;
import com.example.veranstaltung.repository.BesucherBuchungRepository;
import com.example.veranstaltung.repository.BesucherRepository;
import com.example.veranstaltung.repository.BuchungRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BesucherBuchungService {

    private final BesucherBuchungRepository repository;
    private final BesucherRepository besucherRepository;
    private final BuchungRepository buchungRepository;

    /* CREATE / UPDATE (upsert) */
    @Transactional
    public BesucherBuchungDTO save(BesucherBuchungDTO dto) {
        if (!besucherRepository.existsById(dto.besucherId())
                || !buchungRepository.existsById(dto.buchungId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Besucher oder Buchung nicht gefunden");
        }

        BesucherBuchung entity = new BesucherBuchung();
        entity.setId(new BesucherBuchungId(dto.besucherId(), dto.buchungId()));
        entity.setEinzelPreis(dto.einzelPreis());
        entity.setTicketAnzahl(dto.ticketAnzahl());
        entity.setDatum(dto.datum());

        BesucherBuchung saved = repository.save(entity);
        return toDto(saved);
    }

    /* READ */
    @Transactional(readOnly = true)
    public List<BesucherBuchungDTO> findByBesucher(Long besucherId) {
        return repository.findById_BesucherId(besucherId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<BesucherBuchungDTO> findByBuchung(Long buchungId) {
        return repository.findById_BuchungId(buchungId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    /* DELETE */
    @Transactional
    public void delete(Long besucherId, Long buchungId) {
        repository.deleteById(new BesucherBuchungId(besucherId, buchungId));
    }

    /* маппер */
    private BesucherBuchungDTO toDto(BesucherBuchung e) {
        return new BesucherBuchungDTO(
                e.getId().getBesucherId(),
                e.getId().getBuchungId(),
                e.getEinzelPreis(),
                e.getTicketAnzahl(),
                e.getDatum());
    }
}