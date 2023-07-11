package com.proyecto.controller;

import com.proyecto.domain.Actividad;
import com.proyecto.service.ActividadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actividad")
public class ActividadController {
    @Autowired
    private ActividadService actividadService;

    @GetMapping("/listado")
    public String page(Model model) {
        List<Actividad> actividades = actividadService.getActividades(false);
        model.addAttribute("actividades", actividades);
        model.addAttribute("totalActividades", actividades.size());
        return "/actividad/listado";
    }

    @GetMapping("/nuevo")
    public String actividadNuevo(Actividad actividad) {
        return "/actividad/modifica";
    }

    @PostMapping("/guardar")
    public String actividadGuardar(Actividad actividad, Model model) {
        actividadService.save(actividad);
        model.addAttribute("actividad", actividad);
        return "redirect:/actividad/listado";
    }

    @GetMapping("/eliminar/{idActividad}")
    public String actividadEliminar(Actividad actividad) {
        actividadService.delete(actividad);
        return "redirect:/actividad/listado";
    }

    @GetMapping("/modificar/{idActividad}")
    public String actividadModificar(Actividad actividad, Model model) {
        actividad = actividadService.getActividad(actividad);
        model.addAttribute("actividad", actividad);
        return "/actividad/modifica";
    }
}
