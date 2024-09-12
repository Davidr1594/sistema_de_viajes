package com.farsiman.sistema_de_viajes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "sucursal", fetch = FetchType.EAGER)
    private List<SucursalColaborador> sucursalColaboradores;

    public Sucursal() {
    }

    public Sucursal(Long id, String nombre, String direccion, List<SucursalColaborador> sucursalColaboradores) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<SucursalColaborador> getSucursalColaboradores() {
        return sucursalColaboradores;
    }

    public void setSucursalColaboradores(List<SucursalColaborador> sucursalColaboradores) {
        this.sucursalColaboradores = sucursalColaboradores;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
