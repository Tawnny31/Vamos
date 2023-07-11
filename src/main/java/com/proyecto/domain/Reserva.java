package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;
    
    private String codigo;
    private String fecha;
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    public Reserva() {
    }

    public Reserva(String codigo, String fecha, int cantidad, Usuario usuario, Evento evento) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.evento = evento;
    }

}
