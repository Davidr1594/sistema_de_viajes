
package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.Colaborador;
import com.farsiman.sistema_de_viajes.repository.IColaboradorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */

@Service
public class ColaboradorServiceImpl implements IColaboradorService{
    
    @Autowired
    IColaboradorRepository colaboradorRepo;

    @Override
    public List<Colaborador> getColaboradores() {
        return colaboradorRepo.findAll();
    }

    @Override
    public void saveColaborador(Colaborador colaborador) {
        colaboradorRepo.save(colaborador);
    }

    @Override
    public void deleteColaborador(Long id) {
        colaboradorRepo.deleteById(id);
    }

    @Override
    public Colaborador findColaborador(Long id) {
       Colaborador colaborador = colaboradorRepo.findById(id).orElse(null);
       return colaborador;
    }

    @Override
    public void editColaborador(Colaborador colaborador) {
        colaboradorRepo.save(colaborador);
    }
    
    
}
