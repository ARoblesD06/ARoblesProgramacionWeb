/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Colonia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "Ingresa datos")
    private  int idcolonia;
    @Basic
    private String nombre;
    private String cp;
    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;
    //Sobre carga de constructores
    public Colonia() {
    }

    public Colonia(int idcolonia) {
        this.idcolonia = idcolonia;
    }

    public Colonia(int idcolonia, String cp) {
        this.idcolonia = idcolonia;
        this.cp = cp;
    }

    public Colonia(int idcolonia, String cp, Municipio municipio) {
        this.idcolonia = idcolonia;
        this.cp = cp;
        this.municipio = municipio;
    }
    //Metodos Get and Set

    public int getIdcolonia() {
        return idcolonia;
    }

    public void setIdcolonia(int idcolonia) {
        this.idcolonia = idcolonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Colonia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
