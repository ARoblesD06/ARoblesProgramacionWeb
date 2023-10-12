/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.DAO;

import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Inmueble;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Servicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InmuebleDAOImplementation implements IInmuebleDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Inmueble> GetAll() {
        TypedQuery<Inmueble> query = entityManager.createQuery("FROM Inmueble", Inmueble.class);
        List<Inmueble> Inmuebles = query.getResultList();
        return Inmuebles;

    }

    @Override
    @Transactional
    public int Add(Inmueble inmueble) {
        entityManager.persist(inmueble);
        return inmueble.getIdInmueble();
    }

    @Override
    public Inmueble GetById(int idinmuebleeditable) {
        TypedQuery<Inmueble> query = entityManager.createQuery("FROM Inmueble WHERE idinmueble=:idinmuebleeditable", Inmueble.class);
        query.setParameter("idinmuebleeditable", idinmuebleeditable);
        return query.getSingleResult();
    }

    @Override
    public void Update(Inmueble inmueble) {
        entityManager.merge(inmueble);
    }

    @Override
    @Transactional
    public void Delete(Inmueble inmueble) {
        entityManager.remove(inmueble);
    }

}
