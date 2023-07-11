package com.proyecto.dao;

import com.proyecto.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoDao extends JpaRepository<Evento, Long>{
    
}
