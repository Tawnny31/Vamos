
package com.proyecto.Repository;

import com.proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tawnny Elizondo
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
