/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.DAO;

import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Direccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DireccionDAOImplementation implements IDireccionDAO{
     private EntityManager entityManager;
     
      @Autowired//inyeccion de independencias 
    public DireccionDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Direccion> GetAll() {
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion ", Direccion.class);
        List<Direccion> direcciones = query.getResultList();
        return direcciones;
    }

    @Override
    @Transactional 
    public void Add(Direccion direccion) {
        entityManager.persist(direccion);
    }
    @Override
    public Direccion GetById(int idusuario ) { 
        //JPQL
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion WHERE usuario.idusuario=:idusuario", Direccion.class);
        query.setParameter("idusuario", idusuario);
        Direccion direccion;
        try {
            direccion = query.getSingleResult();
        } catch (Exception e) {
            direccion = new Direccion();
        }  
        return query.getSingleResult();
    }
}
