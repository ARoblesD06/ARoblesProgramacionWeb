package com.digis01.ARoblesTestProgramacionNCapasWeb.JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Moneda {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmoneda;
    @Basic
    private  String nombre;
    //Sobre carga de constructores
    public Moneda() {
    }

    public Moneda(int idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Moneda(int idmoneda, String nombre) {
        this.idmoneda = idmoneda;
        this.nombre = nombre;
    }
    //Modificadores de acceso

    public int getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(int idmoneda) {
        this.idmoneda = idmoneda;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
