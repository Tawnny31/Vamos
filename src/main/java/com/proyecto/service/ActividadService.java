package com.proyecto.service;

import com.proyecto.domain.Actividad;
import java.util.List;

public interface ActividadService {
    List<Actividad> getActividades(boolean activas);

    Actividad getActividad(Actividad actividad);

    void save(Actividad actividad);

    void delete(Actividad actividad);
}
