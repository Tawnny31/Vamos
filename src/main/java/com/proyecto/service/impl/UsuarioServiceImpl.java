package com.proyecto.service.impl;

import com.proyecto.Repository.UsuarioRepository;
import com.proyecto.dao.UsuarioRegistroDao;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.UsuarioService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tawnny Elizondo
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario guardarUsuario(UsuarioRegistroDao registroDao) {
         Usuario usuario=new Usuario( registroDao.getNombreUsuario(),
                 registroDao.getEmailUsuario(),
                 registroDao.getPassword(), Arrays.asList(new Rol("ROL_USER")));
        return usuarioRepository.save(usuario);
         
    }
    
}
