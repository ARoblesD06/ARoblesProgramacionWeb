/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.DAO;

import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Servicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServicioDAOImplementation implements IServicioDAO {

    private EntityManager entityManager;

    @Autowired
    public ServicioDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Servicio> GetAll() {
        TypedQuery<Servicio> query = entityManager.createQuery("FROM Servicio", Servicio.class);
        List<Servicio> Servicios = query.getResultList();
        return Servicios;
    }

    @Override
    @Transactional
    public int add(Servicio servicio) {
        entityManager.persist(servicio);
        return servicio.getIdservicio();
    }

    @Override
    @Transactional
    public void Delete(Servicio servicio) {
        entityManager.remove(servicio);
    }

    @Override
    public Servicio GetById(int idservicioeditable) {
        TypedQuery<Servicio> query = entityManager.createQuery("FROM Servicio WHERE idservicio=:idservicioeditable", Servicio.class);
        query.setParameter("idservicioeditable", idservicioeditable);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Servicio servicio) {
        entityManager.merge(servicio);
    }

}
