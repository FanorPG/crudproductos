package com.cafashop.ventas.controlador;

import com.cafashop.ventas.entidad.Cuenta;
import com.cafashop.ventas.servicio.cuenta.AccountServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class AccountControlador {

    @Autowired
    private AccountServicio accountServicio;

    @GetMapping({"/cuentas", "/"})
    public String listarCuentas(Model modelo) {
        modelo.addAttribute("localDateTime", LocalDate.now().toString());
        modelo.addAttribute("cuentas", accountServicio.listarTodasLasCuetas());
        return "cuentas";
    }

    @GetMapping("/cuentas/nuevo")
    public String crearCuentaFormulario(Model modelo) {
        Cuenta cuenta = new Cuenta();
        modelo.addAttribute("cuenta", cuenta);
        return "crear_cuenta";
    }

    @PostMapping("/cuentas")
    public String guardarCuenta(@ModelAttribute("cuenta") Cuenta cuenta, RedirectAttributes redirectAttrs) {
        accountServicio.guardarCuenta(cuenta);
        redirectAttrs
                .addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable("id") Long id, Model modelo) {
        modelo.addAttribute("cuenta", accountServicio.obtenerCuentaPorEmail(id));
        return "editar_cuenta";
    }

    @PostMapping("/cuentas/{id}")
    public String actualizarCuenta(@PathVariable("id") Long id, @ModelAttribute("cuenta") Cuenta cuenta, Model modelo) {
        Cuenta cuentaExistente = accountServicio.obtenerCuentaPorEmail(id);
        cuentaExistente.setEmail(cuenta.getEmail());
        cuentaExistente.setPass(cuenta.getPass());
        cuentaExistente.setCapacity(cuenta.getCapacity());
        cuentaExistente.setType(cuenta.getType());
        cuentaExistente.setFechaVence(cuenta.getFechaVence());
        accountServicio.actualizarCuenta(cuentaExistente);
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{id}")
    public String eliminarCuenta(@PathVariable Long id) {
        accountServicio.eliminarCuenta(id);
        return "redirect:/cuentas";
    }


}
