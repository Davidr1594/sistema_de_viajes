package com.farsiman.sistema_de_viajes.controller;

import com.farsiman.sistema_de_viajes.model.Colaborador;
import com.farsiman.sistema_de_viajes.model.Sucursal;
import com.farsiman.sistema_de_viajes.model.SucursalColaborador;
import com.farsiman.sistema_de_viajes.service.IColaboradorService;
import com.farsiman.sistema_de_viajes.service.ISucursalColaboradorService;
import com.farsiman.sistema_de_viajes.service.ISucursalService;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author david
 */
@Component
public class SucursalColaboradorController {

    @Autowired
    ISucursalColaboradorService sucursalColaboradorService;
    @Autowired
    ISucursalService sucursalService;
    @Autowired
    IColaboradorService colaboradorService;

    public void saveRelationSucursalColaborador(Long sucursalId, Long colaboradorId, double kms) {

        Sucursal sucursal = sucursalService.findSucursal(sucursalId);
        Colaborador colaborador = colaboradorService.findColaborador(colaboradorId);

        SucursalColaborador sucursalColaborador = new SucursalColaborador();
        sucursalColaborador.setSucursal(sucursal);
        sucursalColaborador.setColaborador(colaborador);
        sucursalColaborador.setDistancia(kms);

        sucursalColaboradorService.saveSucursalColaborador(sucursalColaborador);
    }

    @Transactional
    public List<SucursalColaborador> getSucursalColaboradores() {

        return sucursalColaboradorService.getSucursalColaboradores();
    }

    public SucursalColaborador getSucursalColaboradorByIdSucursal(Long sucursalId) {
        return sucursalColaboradorService.findSucursalColaborador(sucursalId);
    }

    public SucursalColaborador getSucursalColaborador(String nombreSucursal) {
        List<SucursalColaborador> listSucursalColaborador = this.getSucursalColaboradores();
        for (SucursalColaborador sucursalColaborador : listSucursalColaborador) {
            if (sucursalColaborador.getSucursal().getNombre().equals(nombreSucursal)) {

                return sucursalColaborador;
            }
        }
        return null;
    }
   public boolean existsRelation(Long sucursalId, Long colaboradorId) {
        return sucursalColaboradorService.findRelation(sucursalId, colaboradorId).isPresent();
    }

    
}
