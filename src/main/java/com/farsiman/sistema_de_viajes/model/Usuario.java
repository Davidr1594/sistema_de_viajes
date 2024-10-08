package com.farsiman.sistema_de_viajes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author david
 */
@Entity
@Table(name = "usuarios")
@Component
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String contrasenia;
    private String rol;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String contrasenia, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void logOut() {
        this.id = null;
        this.nombre = null;
        this.contrasenia = null;
        this.rol = null;
    }

}
