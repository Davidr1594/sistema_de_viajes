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
@Table(name = "transportistas")
public class Transportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private double tarifaPorKM;

    @OneToMany(mappedBy = "transportista")
    private List<Viaje> viajes;

    public Transportista() {
    }

    public Transportista(Long id, String nombre, String apellido, double tarifaPorKM, List<Viaje> viajes) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tarifaPorKM = tarifaPorKM;
        this.viajes = viajes;
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

    public double getTarifaPorKM() {
        return tarifaPorKM;
    }

    public void setTarifaPorKM(double tarifaPorKM) {
        this.tarifaPorKM = tarifaPorKM;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

}
