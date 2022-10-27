package com.cafashop.ventas.controlador;

import com.cafashop.ventas.servicio.pantalla.PantallaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PantallaControlador {

    @Autowired
    private PantallaServicio servicio;

    @GetMapping({"/pantallas"})
    public String listarPantallas(Model modelo) {
        modelo.addAttribute("pantallas", servicio.listarTodasLasPantallas());
        return "pantallas";
    }
    @GetMapping("/pantallas/{id}")
    public String mostrarFormularioDeEditar(@PathVariable("id") String id, Model modelo) {
        modelo.addAttribute("pantallas", servicio.obtenerPantallasPorEmail(id));
        return "pantallas";
    }
}
