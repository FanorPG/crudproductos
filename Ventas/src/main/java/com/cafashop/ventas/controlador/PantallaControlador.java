package com.cafashop.ventas.controlador;

import com.cafashop.ventas.entidad.Cuenta;
import com.cafashop.ventas.entidad.Pantalla;
import com.cafashop.ventas.servicio.cuenta.AccountServicio;
import com.cafashop.ventas.servicio.pantalla.PantallaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PantallaControlador {

    @Autowired
    private PantallaServicio servicio;
    @Autowired
    private AccountServicio accountServicio;

    @GetMapping({"/pantallas"})
    public String listarPantallas(Model modelo) {
        modelo.addAttribute("pantallas", servicio.listarTodasLasPantallas());
        return "pantallas";
    }
    @GetMapping("/pantallas/{id}")
    public String mostrarPantallaDeCuenta(@PathVariable("id") String id, Model modelo) {
        modelo.addAttribute("pantallas", servicio.obtenerPantallasPorEmail(id));
        return "pantallas";
    }

    @PostMapping("/pantallas")
    public String guardarPantalla(@ModelAttribute("pantalla") Pantalla pantalla) {
        servicio.guardarPantalla(pantalla);
        return "redirect:/pantallas";
    }

    @GetMapping("/pantallas/nuevo")
    public String crearCuentaFormulario(Model modelo) {
        Pantalla pantalla = new Pantalla();
        modelo.addAttribute("pantalla", pantalla);
        return "crear_pantalla";
    }

    @GetMapping("/pantallas/eliminar/{id}")
    public String eliminarPantalla(@PathVariable Long id) {
        servicio.eliminarPantalla(id);
        return "redirect:/pantallas";
    }

    @GetMapping("/pantallas/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable("id") Long id, Model modelo) {
        modelo.addAttribute("pantalla", servicio.obtenerPantallaPorId(id));
        return "editar_pantalla";
    }

    @PostMapping("/pantallas/actualizar/{id}")
    public String actualizarCuenta(@PathVariable("id") Long id, @ModelAttribute("pantalla") Pantalla pantalla, Model modelo) {
        Pantalla pantalla1 = new Pantalla();
        pantalla1.setId(id);
        pantalla1.setEmail(pantalla.getEmail());
        pantalla1.setFechaVence(pantalla.getFechaVence());
        pantalla1.setFechaInicio(pantalla.getFechaInicio());
        pantalla1.setName(pantalla.getName());
        pantalla1.setPin(pantalla.getPin());
        servicio.actualizarPantalla(pantalla1);
        return "redirect:/pantallas";
    }

    @GetMapping("/pantallas/entrega/{id}")
    public String enviarProducto(@PathVariable("id") Long id, Model modelo) {
        Pantalla pantalla = servicio.obtenerPantallaPorId(id);
        Cuenta cuenta = accountServicio.obtenerCuentaPorEmail2(pantalla.getEmail());
        modelo.addAttribute("pantalla", pantalla);
        modelo.addAttribute("pass", cuenta.getPass());
        modelo.addAttribute("type", cuenta.getType());
        return "entrega_pantalla";
    }
}
