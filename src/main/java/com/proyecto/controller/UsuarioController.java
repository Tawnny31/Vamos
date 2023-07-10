
package com.proyecto.controller;

import com.proyecto.dao.UsuarioRegistroDao;
import com.proyecto.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tawnny Elizondo
 */
@Controller
@RequestMapping("/registro")
@Slf4j
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @ModelAttribute("usuario")
    public UsuarioRegistroDao retornarNuevoUsuarioDao(){
        
        return new UsuarioRegistroDao();
        
    }
    
    @GetMapping
    public String mostarFormularioRegistro() {
        return "registro";
    }
    
    @PostMapping
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioRegistroDao registroDao){
        usuarioService.guardarUsuario(registroDao);
        return "redirect:/registro?exito";  
    }
    
}
