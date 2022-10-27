package com.cafashop.ventas.servicio.pantalla;

import com.cafashop.ventas.entidad.Pantalla;
import com.cafashop.ventas.repositorio.PantallaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantallaServicioImpl implements PantallaServicio{
    @Autowired
    private PantallaRepositorio pantallaRepositorio;
    @Override
    public List<Pantalla> listarTodasLasPantallas() {
        return pantallaRepositorio.findAll();
    }
    @Override
    public Pantalla guardarPantalla(Pantalla cuenta) {
        return pantallaRepositorio.save(cuenta);
    }

    @Override
    public Pantalla obtenerPantallaPorId(Long id) {
        return pantallaRepositorio.findById(id).get();
    }

    @Override
    public Pantalla actualizarPantalla(Pantalla cuenta) {
        return pantallaRepositorio.save(cuenta);
    }

    @Override
    public void eliminarPantalla(Long id) {
        pantallaRepositorio.deleteById(id);
    }

    @Override
    public List<Pantalla> obtenerPantallasPorEmail(String email) {
        return pantallaRepositorio.listaDePantallaDeCuenta(email);
    }
}
