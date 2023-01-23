package com.az.ejemplobd.controladores;

import com.az.ejemplobd.entidades.Vehiculo;
import com.az.ejemplobd.repositorios.RepositorioVehiculos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorRestVehiculos {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControladorRestVehiculos.class);
    RepositorioVehiculos repoVehiculos;

    public ControladorRestVehiculos(RepositorioVehiculos repoVehiculos) {
        this.repoVehiculos = repoVehiculos;
    }

    @GetMapping("vehiculos")
    public List<Vehiculo> getTodos() {
        LOGGER.debug("GET vehiculos");
        return this.repoVehiculos.findAll();
    }
}
