/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.DAO;

import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Municipio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MunicipioDAOImplementation implements IMunicipioDao {

    private EntityManager entityManager;

    public MunicipioDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Municipio> GetByIdEstado(int IdEstado) {
        TypedQuery<Municipio> query = entityManager.createQuery("FROM Municipio  WHERE estado.idestado = :id", Municipio.class);
        query.setParameter("id", IdEstado);
        List<Municipio> municipios = query.getResultList();
        return municipios;
    }

    @Override
    public List<Municipio> GetAll() {
        TypedQuery<Municipio> query = entityManager.createQuery("FROM Municipio", Municipio.class);
        List<Municipio> direcciones = query.getResultList();

        return direcciones;
    }
}


