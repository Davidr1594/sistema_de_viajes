
package com.farsiman.sistema_de_viajes.repository;

import com.farsiman.sistema_de_viajes.model.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */

@Repository
public interface ITransportistaRepository extends JpaRepository<Transportista, Long>{
    
}
