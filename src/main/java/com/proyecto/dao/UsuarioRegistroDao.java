
package com.proyecto.dao;

import lombok.Data;

/**
 *
 * @author Tawnny Elizondo
 */

@Data
public class UsuarioRegistroDao {
    
    private Long idUsuario;
    private String nombreUsuario;
    private String emailUsuario;
    private String password;

    public UsuarioRegistroDao() {
    }

    public UsuarioRegistroDao(String nombreUsuario, String emailUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.password = password;
    }

    public UsuarioRegistroDao(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
    
    
}
