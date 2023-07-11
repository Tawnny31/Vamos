package com.proyecto.controller;

import com.proyecto.domain.Reserva;
import com.proyecto.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping("/listado")
    public String page(Model model) {
        List<Reserva> reservas = reservaService.getReservas();
        model.addAttribute("reservas", reservas);
        model.addAttribute("totalReservas", reservas.size());
        return "/reserva/listado";
    }

    @GetMapping("/nuevo")
    public String reservaNueva(Reserva reserva) {
        return "/reserva/modifica";
    }

    @PostMapping("/guardar")
    public String reservaGuardar(Reserva reserva, Model model) {
        reservaService.save(reserva);
        model.addAttribute("reserva", reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/eliminar/{idReserva}")
    public String reservaEliminar(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{idReserva}")
    public String reservaModificar(Reserva reserva, Model model) {
        reserva = reservaService.getReserva(reserva);
        model.addAttribute("reserva", reserva);
        return "/reserva/modifica";
    }
}
