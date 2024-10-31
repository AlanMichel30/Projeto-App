package com.LibrasTils.LibrasTils.models.evento;

import java.time.LocalDate;
import java.time.LocalTime;

public record EventoRequest(Long id,
                            String titulo,
                            String tema,
                            String tipo,
                            LocalDate data,
                            LocalTime horario,
                            String lugar,
                            String descricao ) {
    public Evento toEvento() {

        return new Evento(id(),titulo(),tema(),tipo(),data(),horario(),lugar(),descricao());
    }
}