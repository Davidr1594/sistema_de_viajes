package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.Transportista;
import com.farsiman.sistema_de_viajes.repository.ITransportistaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class TransportistaServiceImpl implements ITransportistaService {

    @Autowired
    ITransportistaRepository transportistaRepo;

    @Override
    public List<Transportista> getTransportistas() {
        return transportistaRepo.findAll();
    }

    @Override
    public void saveTransportista(Transportista transportista) {
        transportistaRepo.save(transportista);
    }

    @Override
    public void deleteTransportista(Long id) {
        transportistaRepo.deleteById(id);
    }

    @Override
    public Transportista findTransportista(Long id) {
        return transportistaRepo.findById(id).orElse(null);
    }

    @Override
    public void editTransportista(Transportista transportista) {
        transportistaRepo.save(transportista);
    }

}
