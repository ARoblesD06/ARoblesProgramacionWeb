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

@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idservicio;
    @Basic
    private String nombre;
    //Sobre carga de constructores

    public Servicio() {
    }

    public Servicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public Servicio(int idservicio, String nombre) {
        this.idservicio = idservicio;
        this.nombre = nombre;
    }
    //SETTER AND GETTER

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}