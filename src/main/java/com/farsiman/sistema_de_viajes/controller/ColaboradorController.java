
package com.farsiman.sistema_de_viajes.controller;

import java.util.List;
import org.springframework.stereotype.Component;
import com.farsiman.sistema_de_viajes.model.Colaborador;
import com.farsiman.sistema_de_viajes.service.IColaboradorService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author david
 */
@Component
public class ColaboradorController {
    @Autowired
    IColaboradorService colaboradorService;
    
    public List<Colaborador> getColaboradores(){
        return colaboradorService.getColaboradores();
    }
    
    public Colaborador getByIdColaborador(Long colaboradorId){
        return colaboradorService.findColaborador(colaboradorId);
    }

    public List<Colaborador> getColaboradores(List<Long> listIdColaboradores) {
        List<Colaborador> listColaboradores = new ArrayList<Colaborador>();
        for(Long idColaborador : listIdColaboradores){
            Colaborador colaborador = this.getByIdColaborador(idColaborador);
            if (colaborador != null) {
                listColaboradores.add(colaborador);
                
            }
        }
        return listColaboradores;
    }
    
}
