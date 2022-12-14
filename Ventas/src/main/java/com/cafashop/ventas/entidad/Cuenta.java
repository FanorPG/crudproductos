package com.cafashop.ventas.entidad;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "account")
@Data
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "type")
    private String type;
    @Column(name = "pass")
    private String pass;
    @Column(name = "capacity")
    private String capacity;
    @Column(name = "fechavence")
    private String fechaVence;
}
