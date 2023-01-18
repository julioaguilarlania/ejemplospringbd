package com.az.ejemplobd.controladores;

import com.az.ejemplobd.entidades.Vehiculo;
import com.az.ejemplobd.repositorios.RepositorioVehiculos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorVehiculos {

    final static Logger LOGGER = LoggerFactory.getLogger(ControladorVehiculos.class);
    RepositorioVehiculos repoVehiculos;

    public ControladorVehiculos(RepositorioVehiculos repoVehiculos) {
        this.repoVehiculos = repoVehiculos;
    }

    @RequestMapping("vehiculos")
    public ModelAndView getVehiculos() {
        LOGGER.debug("vehiculos()");
        ModelAndView mav = new ModelAndView("listaVehiculos");
        List<Vehiculo> vehiculos = this.repoVehiculos.findAll();
        mav.addObject("vehiculos", vehiculos);
        return mav;
    }
}
