
package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="evento")
public class Evento implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_evento")
    
    private Long idEvento;
    private String dirLugar;
    private String provincia;
    private String canton;
    private String distrito;
    private String hora;
    private String fecha;
    private String rutaImagen;
    private String comentario; 
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Evento() {
    }

    public Evento(String dirLugar, String provincia, String canton, String distrito, String hora,String fecha,String rutaImagen,String comentario, boolean activo, Categoria categoria) {
        this.dirLugar = dirLugar;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.hora = hora;
        this.fecha = fecha;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        this.categoria = categoria;
    }
    
}
