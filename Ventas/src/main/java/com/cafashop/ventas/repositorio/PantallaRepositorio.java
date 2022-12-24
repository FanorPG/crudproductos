package com.cafashop.ventas.repositorio;

import com.cafashop.ventas.entidad.Pantalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PantallaRepositorio extends JpaRepository<Pantalla, Long> {
    @Query(value = "SELECT * FROM screen WHERE email=:email", nativeQuery = true)
    List<Pantalla> listaDePantallaDeCuenta(String email);
}
