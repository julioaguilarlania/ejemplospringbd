package com.az.ejemplobd.repositorios;

import com.az.ejemplobd.entidades.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioVehiculos extends JpaRepository<Vehiculo,String> {
}
