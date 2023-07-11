package com.proyecto.service.impl;

import com.proyecto.dao.ActividadDao;
import com.proyecto.domain.Actividad;
import com.proyecto.service.ActividadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActividadServiceImpl implements ActividadService {
    @Autowired
    private ActividadDao actividadDao;

    @Override
    @Transactional(readOnly = true)
    public List<Actividad> getActividades(boolean activas) {
        List<Actividad> actividades = actividadDao.findAll();

        if (activas) {

        }

        return actividades;
    }

    @Override
    @Transactional(readOnly = true)
    public Actividad getActividad(Actividad actividad) {
        return actividadDao.findById(actividad.getIdActividad()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Actividad actividad) {
        actividadDao.save(actividad);
    }

    @Override
    @Transactional
    public void delete(Actividad actividad) {
        actividadDao.delete(actividad);
    }
}
