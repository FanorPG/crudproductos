package com.cafashop.ventas.repositorio;

import com.cafashop.ventas.entidad.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositorio extends JpaRepository<Cuenta, String> {
}