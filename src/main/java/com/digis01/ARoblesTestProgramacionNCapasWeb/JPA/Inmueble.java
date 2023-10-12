/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Inmueble {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idinmueble;
    private String nombre;
    private String descripcion; 
    
   // @Table(name = "NUMERORECAMARAS")
    private int numerorecamaras;
    private int numerobanios;
    private int numeroestacionamiento;
    private Double superficie;
    private Double precio;
    
    private Double laditud;
    private Double longitud;
    @Lob
    private String imagen;
    
    @ManyToOne
    @JoinColumn(name = "idtipoinmueble") // Mapea a la columna 'idTipoInmueble'
    private TipoInmueble tipoInmueble;

    @ManyToOne
    @JoinColumn(name = "idantiguedad") // Mapea a una columna diferente, por ejemplo, 'idAntiguedad'
    private Antiguedad antiguedad;

    @ManyToOne
    @JoinColumn(name = "idmoneda")
    private Moneda moneda;
    
    @ManyToOne
    @JoinColumn(name = "idunidad")
    private Unidad unidad;
//    @ManyToOne
//    @JoinColumn(name = "idDireccion")
//    private Direccion direccion;
    
    //Sobre carga de Constructores

    public Inmueble() {
    }

    public Inmueble(int idinmueble) {
        this.idinmueble = idinmueble;
    }

    public Inmueble(int idinmueble, String nombre, String descripcion, int numerorecamaras, int numerobanios, int numeroestacionamiento, Double superficie, Double precio, Double laditud, Double longitud, String imagen, TipoInmueble tipoInmueble, Antiguedad antiguedad, Moneda moneda, Unidad unidad) {
        this.idinmueble = idinmueble;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numerorecamaras = numerorecamaras;
        this.numerobanios = numerobanios;
        this.numeroestacionamiento = numeroestacionamiento;
        this.superficie = superficie;
        this.precio = precio;
        this.laditud = laditud;
        this.longitud = longitud;
        this.imagen = imagen;
        this.tipoInmueble = tipoInmueble;
        this.antiguedad = antiguedad;
        this.moneda = moneda;
        this.unidad = unidad;
    }

    

    public int getIdinmueble() {
        return idinmueble;
    }

    public void setIdinmueble(int idinmueble) {
        this.idinmueble = idinmueble;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
    public int getIdInmueble() {
        return idinmueble;
    }

    public void setIdInmueble(int idinmueble) {
        this.idinmueble = idinmueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumerorecamaras() {
        return numerorecamaras;
    }

    public void setNumerorecamaras(int numerorecamaras) {
        this.numerorecamaras = numerorecamaras;
    }

    public int getNumerobanios() {
        return numerobanios;
    }

    public void setNumerobanios(int numerobanios) {
        this.numerobanios = numerobanios;
    }

    public int getNumeroestacionamiento() {
        return numeroestacionamiento;
    }

    public void setNumeroestacionamiento(int numeroestacionamiento) {
        this.numeroestacionamiento = numeroestacionamiento;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public Double getLaditud() {
        return laditud;
    }

    public void setLaditud(Double laditud) {
        this.laditud = laditud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmueble tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public Antiguedad getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Antiguedad antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    

    
}
