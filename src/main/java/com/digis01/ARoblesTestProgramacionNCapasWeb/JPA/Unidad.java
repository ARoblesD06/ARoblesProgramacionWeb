package com.digis01.ARoblesTestProgramacionNCapasWeb.JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Unidad {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idunidad;
    @Basic
    private String nombre;
    //Sobre carga de constructores
    public Unidad() {
    }

    public Unidad(int idunidad) {
        this.idunidad = idunidad;
    }

    public Unidad(int idunidad, String nombre) {
        this.idunidad = idunidad;
        this.nombre = nombre;
    }

    
    //Modificadores de acceso

    public int getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(int idunidad) {
        this.idunidad = idunidad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
