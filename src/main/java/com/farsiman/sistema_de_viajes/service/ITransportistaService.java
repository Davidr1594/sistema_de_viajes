package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.Transportista;
import java.util.List;

/**
 *
 * @author david
 */
public interface ITransportistaService {

    public List<Transportista> getTransportistas();

    public void saveTransportista(Transportista transportista);

    public void deleteTransportista(Long id);

    public Transportista findTransportista(Long id);

    public void editTransportista(Transportista transportista);

}
