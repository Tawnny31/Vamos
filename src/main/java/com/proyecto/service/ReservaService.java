package com.proyecto.service;

import com.proyecto.domain.Reserva;
import java.util.List;

public interface ReservaService {
    List<Reserva> getReservas();

    Reserva getReserva(Reserva reserva);

    void save(Reserva reserva);

    void delete(Reserva reserva);
}
