package com.farsiman.sistema_de_viajes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 *
 * @author david
 */
@Entity
@Table(name = "viajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    private double distanciaTotal;

    @ManyToOne
    @JoinColumn(name = "sucursal_colaborador_id")
    private SucursalColaborador sucursalColaborador;

    @ManyToOne
    @JoinColumn(name = "Transportista_id")
    private Transportista transportista;

    @ManyToMany
    @JoinTable(
            name = "viaje_colaborador",
            joinColumns = @JoinColumn(name = "viaje_id"),
            inverseJoinColumns = @JoinColumn(name = "colaborador_id")
    )
    private List<Colaborador> colaboradores;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioRegistro;

    public Viaje() {
    }

    public Viaje(Long id, Date fecha, double distanciaTotal, SucursalColaborador sucursalColaborador, Transportista transportista, List<Colaborador> colaboradores, Usuario usuarioRegistro) {
        this.id = id;
        this.fecha = fecha;
        this.distanciaTotal = distanciaTotal;
        this.sucursalColaborador = sucursalColaborador;
        this.transportista = transportista;
        this.colaboradores = colaboradores;
        this.usuarioRegistro = usuarioRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(double distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

    public SucursalColaborador getSucursalColaborador() {
        return sucursalColaborador;
    }

    public void setSucursalColaborador(SucursalColaborador sucursalColaborador) {
        this.sucursalColaborador = sucursalColaborador;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

}
