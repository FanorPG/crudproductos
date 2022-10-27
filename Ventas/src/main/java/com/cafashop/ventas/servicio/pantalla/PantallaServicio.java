package com.cafashop.ventas.servicio.pantalla;

import com.cafashop.ventas.entidad.Pantalla;

import java.util.List;

public interface PantallaServicio {
    List<Pantalla> listarTodasLasPantallas();
    Pantalla guardarPantalla(Pantalla cuenta);
    Pantalla obtenerPantallaPorId(Long id);
    Pantalla actualizarPantalla(Pantalla cuenta);
    void eliminarPantalla(Long id);
    List<Pantalla> obtenerPantallasPorEmail(String email);
}
