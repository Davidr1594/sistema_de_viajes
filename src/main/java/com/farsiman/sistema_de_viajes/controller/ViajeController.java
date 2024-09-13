package com.farsiman.sistema_de_viajes.controller;

import com.farsiman.sistema_de_viajes.model.Colaborador;
import com.farsiman.sistema_de_viajes.model.SucursalColaborador;
import com.farsiman.sistema_de_viajes.model.Transportista;
import com.farsiman.sistema_de_viajes.model.Usuario;
import com.farsiman.sistema_de_viajes.model.Viaje;
import com.farsiman.sistema_de_viajes.service.IViajeService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author david
 */
@Component
public class ViajeController {

    @Autowired
    IViajeService viajeService;

    public boolean saveViaje() {

        return false;
    }

    public boolean saveViaje(Date fecha, SucursalColaborador sucursalColaborador, Transportista transportista, List<Colaborador> listColaboradoresTotalViaje, Usuario userPrueba, double kmsTotal) {

        Viaje viaje = new Viaje();

        viaje.setColaboradores(listColaboradoresTotalViaje);
        viaje.setDistanciaTotal(kmsTotal);
        viaje.setFecha(fecha);
        viaje.setUsuarioRegistro(userPrueba);
        viaje.setTransportista(transportista);
        viaje.setSucursalColaborador(sucursalColaborador);

        if (viaje != null) {
            viajeService.saveViaje(viaje);
            return true;
        }
        return false;
    }
    public List<Viaje> getViajesBetweenDate(Date fechaInicio, Date fechaFinal){
        
        return viajeService.getViajesBetweenDates(fechaInicio, fechaFinal);
    }
}
