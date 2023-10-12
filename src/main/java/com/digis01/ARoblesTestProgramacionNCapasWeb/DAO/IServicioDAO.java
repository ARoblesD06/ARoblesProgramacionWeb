/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.DAO;

import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Servicio;
import java.util.List;


public interface IServicioDAO {
    List<Servicio>GetAll();
    int add(Servicio servico);
    Servicio GetById(int idservico);
    void Delete (Servicio servicio);
    void update(Servicio servicio);
}
