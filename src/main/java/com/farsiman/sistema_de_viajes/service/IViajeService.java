package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.Viaje;
import java.util.List;

/**
 *
 * @author david
 */
public interface IViajeService {

    public List<Viaje> getViajes();

    public void saveViaje(Viaje viaje);

    public void deleteViaje(Long id);

    public Viaje findViaje(Long id);

    public void editColaborador(Viaje viaje);

}
