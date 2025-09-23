package com.example.veranstaltung.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public record BesucherBuchungDTO(
        @NotNull
        Long besucherId,

        @NotNull
        Long buchungId,

        @PositiveOrZero
        BigDecimal einzelPreis,

        @Positive
        int ticketAnzahl,

        LocalDate datum
) implements Serializable {
}
