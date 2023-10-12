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


@Entity
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmunicipio;
    @Basic
    private String  nombre;
    @ManyToOne
    @JoinColumn(name = "idestado")
    private Estado estado;
    //Sobre carga de constructores

    public Municipio() {
    }

    public Municipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Municipio(int idmunicipio, String nombre) {
        this.idmunicipio = idmunicipio;
        this.nombre = nombre;
    }

    public Municipio(int idmunicipio, String nombre, Estado estado) {
        this.idmunicipio = idmunicipio;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    
    //Metodos Getter and Setter
    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    

    
    
    
}
