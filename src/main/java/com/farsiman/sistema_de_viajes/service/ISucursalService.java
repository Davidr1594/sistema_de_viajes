package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.Sucursal;
import java.util.List;

/**
 *
 * @author david
 */
public interface ISucursalService {

    public List<Sucursal> getSucursales();

    public void saveSucursal(Sucursal sucursal);

    public void deleteSucursal(Long id);

    public Sucursal findSucursal(Long id);

    public void editSucursal(Sucursal sucursal);

}
