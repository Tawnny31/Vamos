
package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author Tawnny Elizondo
 */
@Data
@Entity
@Table(name="rol")
public class Rol {
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Long idRol;
    private String nombreRol;

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Rol() {
    }
    
}
