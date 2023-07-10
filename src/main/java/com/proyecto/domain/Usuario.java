package com.proyecto.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Collection;
import lombok.Data;

/**
 *
 * @author Tawnny Elizondo
 */
@Data
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario implements Serializable {

    //Se utiliza este comando para que la llave primaria se ortogue automáticamente
    private static final long serialVersionUID = 1L;

    //Esta sería la llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;

    //    Se Muestran los demás atributos
    private String nombreUsuario;
    private String emailUsuario;
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarioRol",
            joinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "idRol", referencedColumnName = "id_rol"))
    private Collection<Rol> roles;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String emailUsuario, String password, Collection<Rol> roles) {
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.password = password;
        this.roles = roles;
    }

}
