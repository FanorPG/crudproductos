package com.cafashop.ventas.entidad;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "screen")
public class Pantalla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "pin")
    private Long pin;
    @Column(name = "fechainicio")
    private String fechaInicio;
    @Column(name = "fechavence")
    private String fechaVence;
    @Column(name = "email")
    private String email;
    @Column(name = "cel")
    private String cel;
}
