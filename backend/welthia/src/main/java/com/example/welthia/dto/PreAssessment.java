package com.example.welthia.dto;

import java.util.List;

public record PreAssessment(String resumenGeneral,
        String diagnosticoBienestar,
        String focusAreaPrincipal,
        List<RecomendacionHábito> recomendacionesPersonalizadas) {

    public record RecomendacionHábito(
            String categoria,
            String habitoRecomendado,
            String justificacion
            ) {

    }

}
