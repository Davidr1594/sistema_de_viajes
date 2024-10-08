package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.SucursalColaborador;
import com.farsiman.sistema_de_viajes.repository.ISucursalColaboradorRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class SucursalColaboradorImpl implements ISucursalColaboradorService {

    @Autowired
    private ISucursalColaboradorRepository sucursalColaboradorRepo;

    @Override
    public List<SucursalColaborador> getSucursalColaboradores() {
        return sucursalColaboradorRepo.findAll();
    }

    @Override
    public void saveSucursalColaborador(SucursalColaborador sucursalColaborador) {
        sucursalColaboradorRepo.save(sucursalColaborador);
    }

    @Override
    public void deleteSucursalColaborador(Long id) {
        sucursalColaboradorRepo.deleteById(id);
    }

    @Override
    public SucursalColaborador findSucursalColaborador(Long id) {
        return sucursalColaboradorRepo.findById(id).orElse(null);
    }

    @Override
    public void editSucursalColaborador(SucursalColaborador sucursalColaborador) {
        sucursalColaboradorRepo.save(sucursalColaborador);
    }

    @Override
    public Optional<SucursalColaborador> findRelation(Long sucursalId, Long colaboradorId) {
        return sucursalColaboradorRepo.findRelationBySucursalAndColaborador(sucursalId, colaboradorId);
    }

    
}
