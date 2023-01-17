package com.az.ejemplobd.controladores;

import com.az.ejemplobd.entidades.Vehiculo;
import com.az.ejemplobd.repositorios.RepositorioVehiculos;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorVehiculos {

    RepositorioVehiculos repoVehiculos;

    public ControladorVehiculos(RepositorioVehiculos repoVehiculos) {
        this.repoVehiculos = repoVehiculos;
    }

    public ModelAndView getVehiculos() {
        ModelAndView mav = new ModelAndView("listaVehiculos");
        List<Vehiculo> vehiculos = this.repoVehiculos.findAll();
        return mav;
    }
}
