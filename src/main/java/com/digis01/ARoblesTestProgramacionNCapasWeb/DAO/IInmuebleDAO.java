/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.DAO;

import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Inmueble;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IInmuebleDAO {
    List<Inmueble>GetAll();
    int Add(Inmueble inmueble);
    Inmueble GetById(int idinmuebleeditable);
    void Update(Inmueble inmueble);
    void Delete(Inmueble inmueble);
}
