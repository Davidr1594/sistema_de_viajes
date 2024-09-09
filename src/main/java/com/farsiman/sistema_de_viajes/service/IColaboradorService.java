
package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.Colaborador;
import java.util.List;


/**
 *
 * @author david
 */
public interface IColaboradorService {
    
    public List<Colaborador> getColaborador();

    public void saveColaborador(Colaborador colaborador);

    public void deleteColaborador(Long id);

    public Colaborador findColaborador(Long id);

    public void editColaborador(Colaborador colaborador);

}
