package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.SucursalColaborador;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author david
 */
public interface ISucursalColaboradorService {

    public List<SucursalColaborador> getSucursalColaboradores();

    public void saveSucursalColaborador(SucursalColaborador sucursalColaborador);

    public void deleteSucursalColaborador(Long id);

    public SucursalColaborador findSucursalColaborador(Long id);

    public void editSucursalColaborador(SucursalColaborador sucursalColaborador);

    public Optional<SucursalColaborador> findRelation(Long sucursalId, Long colaboradorId);

    }
