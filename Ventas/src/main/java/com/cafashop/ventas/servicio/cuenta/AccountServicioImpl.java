package com.cafashop.ventas.servicio.cuenta;

import com.cafashop.ventas.entidad.Cuenta;
import com.cafashop.ventas.repositorio.AccountRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServicioImpl implements AccountServicio{
    @Autowired
    private AccountRepositorio acountRepositorio;

    @Override
    public List<Cuenta> listarTodasLasCuetas() {
        return acountRepositorio.findAll();
    }

    @Override
    public Cuenta guardarCuenta(Cuenta cuenta) {
        return acountRepositorio.save(cuenta);
    }

    @Override
    public Cuenta obtenerCuentaPorEmail(Long id) {
        return acountRepositorio.findById(id).get();
    }

    @Override
    public Cuenta actualizarCuenta(Cuenta cuenta) {
        return acountRepositorio.save(cuenta);
    }

    @Override
    public void eliminarCuenta(Long id) {
        acountRepositorio.deleteById(id);
    }

    @Override
    public Cuenta obtenerCuentaPorEmail2(String email) {
        return acountRepositorio.obteneCuentaPorEmail(email);
    }
}
