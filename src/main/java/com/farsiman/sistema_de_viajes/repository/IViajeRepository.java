/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farsiman.sistema_de_viajes.repository;


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
}
