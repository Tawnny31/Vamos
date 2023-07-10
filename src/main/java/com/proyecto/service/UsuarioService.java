
package com.proyecto.service;

import com.proyecto.dao.UsuarioRegistroDao;
import com.proyecto.domain.Usuario;
import java.util.List;

/**
 *
 * @author Tawnny Elizondo
 */
public interface UsuarioService {
     
    public Usuario guardarUsuario(UsuarioRegistroDao registroDao);
     
    }
