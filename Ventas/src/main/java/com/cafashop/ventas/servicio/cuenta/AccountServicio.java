package com.cafashop.ventas.servicio.cuenta;

import com.cafashop.ventas.entidad.Cuenta;

import java.util.List;

public interface AccountServicio {
    List<Cuenta> listarTodasLasCuetas();
    Cuenta guardarCuenta(Cuenta cuenta);
    Cuenta obtenerCuentaPorEmail(Long id);
    Cuenta actualizarCuenta(Cuenta cuenta);
    void eliminarCuenta(Long id);
}
