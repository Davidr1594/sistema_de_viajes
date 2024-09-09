
package com.farsiman.sistema_de_viajes.repository;

import com.farsiman.sistema_de_viajes.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */

@Repository
public interface IColaboradorRepository extends JpaRepository<Colaborador, Long> {
    
}
