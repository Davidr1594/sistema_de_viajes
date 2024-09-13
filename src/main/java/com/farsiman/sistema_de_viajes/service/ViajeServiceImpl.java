package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.Colaborador;
import com.farsiman.sistema_de_viajes.model.Viaje;
import com.farsiman.sistema_de_viajes.repository.IViajeRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class ViajeServiceImpl implements IViajeService {

    @Autowired
    private IViajeRepository viajeRepo;

    @Override
    public List<Viaje> getViajes() {
        return viajeRepo.findAll();
    }

    @Override
    public void saveViaje(Viaje viaje) {
        viajeRepo.save(viaje);
    }

    @Override
    public void deleteViaje(Long id) {
        viajeRepo.deleteById(id);
    }

    @Override
    public Viaje findViaje(Long id) {
        return viajeRepo.findById(id).orElse(null);
    }

    @Override
    public void editColaborador(Viaje viaje) {
        viajeRepo.save(viaje);
    }

    @Override
    public List<Viaje> getViajesBetweenDates(Date fechaInicio, Date fechaFinal) {
        return viajeRepo.findByFechaBetween(fechaInicio, fechaFinal);
    }

    @Override
    public List<Viaje> findByFechaAndColaboradoresIn(Date fecha, List<Colaborador> colaboradores) {
        return viajeRepo.findByFechaAndColaboradoresIn(fecha, colaboradores);
    }

}
