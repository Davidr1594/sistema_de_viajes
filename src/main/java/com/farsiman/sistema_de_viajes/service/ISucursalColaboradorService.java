package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.SucursalColaborador;
import java.util.List;

/**
 *
 * @author david
 */
public interface ISucursalColaboradorService {

    public List<SucursalColaborador> getSucursalColaborador();

    public void saveSucursalColaborador(SucursalColaborador sucursalColaborador);

    public void deleteSucursalColaborador(Long id);

    public SucursalColaborador findSucursalColaborador(Long id);

    public void editSucursalColaborador(SucursalColaborador sucursalColaborador);

}
