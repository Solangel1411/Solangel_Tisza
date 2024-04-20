package com.example.solangeltisza.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="empresa")
@Getter
@Setter

public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razonSocial;
    private String tipoDocumento;
    private String numeroDocumento;
    private String condicion;
    private String distrito;
    private String provincia;
    private String departamento;
    private boolean esAgenteRetencion;
    private int estado;
}
