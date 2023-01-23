package com.az.ejemplobd.controladores;

import com.az.ejemplobd.entidades.Vehiculo;
import com.az.ejemplobd.repositorios.RepositorioVehiculos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

//@Controller
public class ControladorVehiculos {

    final static Logger LOGGER = LoggerFactory.getLogger(ControladorVehiculos.class);
    RepositorioVehiculos repoVehiculos;

    public ControladorVehiculos(RepositorioVehiculos repoVehiculos) {
        this.repoVehiculos = repoVehiculos;
    }

    @RequestMapping("listaVehiculos")
    public ModelAndView getVehiculos() {
        LOGGER.debug("vehiculos()");
        ModelAndView mav = new ModelAndView("listaVehiculos");
        List<Vehiculo> vehiculos = this.repoVehiculos.findAll();
        mav.addObject("vehiculos", vehiculos);
        return mav;
    }

    //@RequestMapping(value="vehiculos", method = RequestMethod.GET)
    @GetMapping("vehiculos")
    @ResponseBody
    public List<Vehiculo> getTodosVehiculos() {
        LOGGER.debug("GET vehiculos");
        return this.repoVehiculos.findAll();
    }

    @GetMapping("vehiculos/{placas}")
    @ResponseBody
    public Optional<Vehiculo> getPorPlacas(@PathVariable("placas") String p) {
        LOGGER.debug("GET vehiculos/id");
        return this.repoVehiculos.findById(p);
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

    @RequestMapping("forma_nuevo")
    public String mostrarFormularioCaptura() {
        LOGGER.debug("forma Captura()");
        return "capturaNuevo";
    }

    @RequestMapping(value="guardar")
    public ModelAndView guardarNuevo(Vehiculo v)
    {
        LOGGER.debug("guardar Vehiculo()");
        ModelAndView mav = new ModelAndView("listaVehiculos");
        try {
            repoVehiculos.save(v);
            mav.addObject("mensaje", "Se guardo el vehiculo");
            mav.addObject("vehiculos", repoVehiculos.findAll());
            LOGGER.trace("Se guardo el vehiculo");
        } catch(IllegalArgumentException iae) {
            mav.setViewName("capturaNuevo");
            mav.addObject("error", iae.getMessage());
            mav.addObject("vehiculo", v);
            LOGGER.warn("Error al guardar Vehiculo:", iae);
        }

        return mav;
    }
}
