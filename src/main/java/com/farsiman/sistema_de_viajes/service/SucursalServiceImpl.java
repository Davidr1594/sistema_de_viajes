
package com.farsiman.sistema_de_viajes.service;

import com.farsiman.sistema_de_viajes.model.Sucursal;
import com.farsiman.sistema_de_viajes.repository.ISucursalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class SucursalServiceImpl implements ISucursalService {
    
    @Autowired
    private ISucursalRepository sucursalRepo;

    @Override
    public List<Sucursal> getSucursales() {
        return sucursalRepo.findAll();
    }

    @Override
    public void saveSucursal(Sucursal sucursal) {
        sucursalRepo.save(sucursal);
    }

    @Override
    public void deleteSucursal(Long id) {
        sucursalRepo.deleteById(id);
    }

    @Override
    public Sucursal findSucursal(Long id) {
        return sucursalRepo.findById(id).orElse(null);
    }

    @Override
    public void editSucursal(Sucursal sucursal) {
        sucursalRepo.save(sucursal);
    }
    
}
