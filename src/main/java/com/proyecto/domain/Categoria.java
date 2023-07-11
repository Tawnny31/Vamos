package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name="id_categoria")
    private Long idCategoria;
    private String catDescripcion;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name="id_categoria")
    List<Evento> eventos;

    public Categoria() {
    }

    public Categoria(String catDescripcion,boolean activo) {
        this.catDescripcion = catDescripcion;
        this.activo = activo;
    }
   

}
