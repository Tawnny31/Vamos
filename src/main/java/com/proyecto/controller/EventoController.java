
package com.proyecto.controller;

import com.proyecto.domain.Categoria;
import com.proyecto.domain.Evento;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.EventoService;
import com.proyecto.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/evento")
public class EventoController  {
    @Autowired
    EventoService eventoService;
    
    @Autowired
    CategoriaService categoriaService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        List<Evento> eventos = eventoService.getEventos(false);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("eventos", eventos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalEventos", eventos.size());
        
        return "/evento/listado";
    }
    
    @GetMapping("/nuevo")
    public String eventoNuevo(Evento evento) {
        return "/evento/modifica";
    }
    
    @PostMapping("/guardar")
    public String eventoGuardar(Evento evento,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            eventoService.save(evento);
            evento.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "evento", 
                            evento.getIdEvento()));
        }
        eventoService.save(evento);
        return "redirect:/evento/listado";
    }

    @GetMapping("/eliminar/{idEvento}")
    public String eventoEliminar(Evento evento) {
        eventoService.delete(evento);
        return "redirect:/evento/listado";
    }

    @GetMapping("/modificar/{idEvento}")
    public String eventoModificar(Evento evento, Model model) {
        evento = eventoService.getEvento(evento);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("evento", evento);
        model.addAttribute("categorias", categorias);
        return "/evento/modifica";
    }
    
    
}
