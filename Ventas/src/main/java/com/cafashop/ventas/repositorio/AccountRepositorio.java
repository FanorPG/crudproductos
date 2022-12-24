package com.cafashop.ventas.repositorio;

import com.cafashop.ventas.entidad.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositorio extends JpaRepository<Cuenta, Long> {
    @Query(value = "SELECT * FROM account WHERE email=:email", nativeQuery = true)
    Cuenta obteneCuentaPorEmail(String email);
}
