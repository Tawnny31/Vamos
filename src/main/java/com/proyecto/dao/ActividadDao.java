package com.proyecto.dao;

import com.proyecto.domain.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadDao extends JpaRepository<Actividad, Long> {
}
