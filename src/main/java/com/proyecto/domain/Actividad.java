package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Long idActividad;

    private String nombre;
    private String provincia;
    private String canton;
    
    // Relaciones con otras entidades
    // ...

    public Actividad() {
    }

    public Actividad(String nombre, String provincia, String canton) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.canton = canton;
    }

    // Getters y setters
    // ...
}
