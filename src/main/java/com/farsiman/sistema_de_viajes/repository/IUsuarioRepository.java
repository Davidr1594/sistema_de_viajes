
package com.farsiman.sistema_de_viajes.repository;

import com.farsiman.sistema_de_viajes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
