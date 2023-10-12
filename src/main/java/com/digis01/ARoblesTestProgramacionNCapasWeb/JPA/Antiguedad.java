
package com.digis01.ARoblesTestProgramacionNCapasWeb.JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Antiguedad {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idantiguedad;
    @Basic
    private String nombre;
    //Sobre carga de contructores
    public Antiguedad() {
    }

    public Antiguedad(int idantiguedad) {
        this.idantiguedad = idantiguedad;
    }

    public Antiguedad(int idantiguedad, String nombre) {
        this.idantiguedad = idantiguedad;
        this.nombre = nombre;
    }
    //Modificadores de acceso

    public int getIdantiguedad() {
        return idantiguedad;
    }

    public void setIdantiguedad(int idantiguedad) {
        this.idantiguedad = idantiguedad;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
