/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.DAO;

import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Municipio;
import java.util.List;

public interface IMunicipioDao {
    List<Municipio>GetAll();
    List<Municipio> GetByIdEstado(int IdEstado);
}
