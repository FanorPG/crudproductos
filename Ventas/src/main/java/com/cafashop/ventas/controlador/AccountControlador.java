package com.cafashop.ventas.controlador;

import com.cafashop.ventas.servicio.AccountServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountControlador {

    @Autowired
    private AccountServicio accountServicio;

    @GetMapping({"/cuentas","/"})
    public String listarCuentas(Model modelo){
        modelo.addAttribute("cuentas",accountServicio.listarTodasLasCuetas());
        return "cuentas";
    }

}
