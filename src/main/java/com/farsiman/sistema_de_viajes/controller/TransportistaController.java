
package com.farsiman.sistema_de_viajes.controller;

import com.farsiman.sistema_de_viajes.model.Transportista;
import com.farsiman.sistema_de_viajes.service.ITransportistaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author david
 */

@Component
public class TransportistaController {
    
    @Autowired
    ITransportistaService transportistaService;
    
    public List<Transportista> getTransportistas(){
        return transportistaService.getTransportistas();
    }
    
    public Transportista getTransportista(String nombreTransportista){
        
        List<Transportista> listTransportistas = this.getTransportistas();
        for(Transportista transportista : listTransportistas){
            if (transportista.getNombre().equals(nombreTransportista)) {
                return transportista;
            }
        }
        
        return null;
    }
}
