
package com.farsiman.sistema_de_viajes.repository;

import com.farsiman.sistema_de_viajes.model.SucursalColaborador;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */

@Repository
public interface ISucursalColaboradorRepository extends JpaRepository<SucursalColaborador, Long>{
    

}
