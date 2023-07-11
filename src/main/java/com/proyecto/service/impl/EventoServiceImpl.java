package com.proyecto.service.impl;

import com.proyecto.dao.EventoDao;
import com.proyecto.domain.Evento;
import com.proyecto.service.EventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    EventoDao eventoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Evento> getEventos(boolean activos) {
        List<Evento> eventos = eventoDao.findAll();

        if (activos) {
            eventos.removeIf(x -> !x.isActivo());
        }

        return eventos;
    }

    @Override
    @Transactional(readOnly = true)
    public Evento getEvento(Evento evento) {
        return eventoDao.findById(evento.getIdEvento()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Evento evento) {
        eventoDao.save(evento);
    }

    @Override
    @Transactional
    public void delete(Evento evento) {
        eventoDao.delete(evento);
    }

}
