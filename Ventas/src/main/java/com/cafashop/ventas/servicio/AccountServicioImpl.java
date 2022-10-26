package com.cafashop.ventas.servicio;

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
}
