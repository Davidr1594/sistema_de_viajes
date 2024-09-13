package com.farsiman.sistema_de_viajes.repository;

import com.farsiman.sistema_de_viajes.model.Colaborador;
import com.farsiman.sistema_de_viajes.model.Viaje;
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
public interface IViajeRepository extends JpaRepository<Viaje, Long> {

    @Query("SELECT v FROM Viaje v WHERE v.fecha >= :fechaInicio AND v.fecha <= :fechaFin")
    List<Viaje> findByFechaBetween(Date fechaInicio, Date fechaFin);

    List<Viaje> findByFechaAndColaboradoresIn(Date fecha, List<Colaborador> colaboradores);

}
