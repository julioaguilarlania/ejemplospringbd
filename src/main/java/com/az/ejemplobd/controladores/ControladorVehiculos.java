package com.az.ejemplobd.controladores;

import com.az.ejemplobd.entidades.Vehiculo;
import com.az.ejemplobd.repositorios.RepositorioVehiculos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "buscar", params = "placas")
    public ModelAndView buscarVehiculo(@RequestParam("placas") String p) {
        LOGGER.debug("buscarVehiculo()");
        ModelAndView mav = new ModelAndView("resultados");
        Optional<Vehiculo> v = repoVehiculos.findById(p); //base.getVehiculoPorPlacas(p);
        if (v.isPresent())
            mav.addObject("vehiculo", v.get());
        return mav;
    }
}
