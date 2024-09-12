
package com.farsiman.sistema_de_viajes.controller;


import com.farsiman.sistema_de_viajes.model.Colaborador;
import java.util.List;
import org.springframework.stereotype.Component;
import com.farsiman.sistema_de_viajes.model.Sucursal;
import com.farsiman.sistema_de_viajes.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author david
 */

@Component
public class SucursalController {
    
    @Autowired
    private ISucursalService sucursalService;
    
    public List<Sucursal> getSucursales(){
        return sucursalService.getSucursales();
    
    }
    
}
