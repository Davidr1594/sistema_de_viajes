package com.farsiman.sistema_de_viajes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author david
 */
@Entity
@Table(name = "colaboradores")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "colaborador")
    private List<SucursalColaborador> sucursalColaboradores;

    public Colaborador() {
    }

    public Colaborador(Long id, String nombre, String apellido, List<SucursalColaborador> sucursalColaboradores) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sucursalColaboradores = sucursalColaboradores;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<SucursalColaborador> getSucursalColaboradores() {
        return sucursalColaboradores;
    }

    public void setSucursalColaboradores(List<SucursalColaborador> sucursalColaboradores) {
        this.sucursalColaboradores = sucursalColaboradores;
    }

}
