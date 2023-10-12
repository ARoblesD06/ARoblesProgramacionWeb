/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.DAO;

import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.TipoInmueble;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TipoInmuebleDAOImplementation implements ITipoInmuebleDAO {

    private EntityManager entityManager;

    @Autowired
    //Constructor para inyecccion de datos
    public TipoInmuebleDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<TipoInmueble> GetAll() {
        TypedQuery<TipoInmueble> query = entityManager.createQuery("FROM TipoInmueble", TipoInmueble.class);
        List<TipoInmueble> tipoinmuebles = query.getResultList();
        return tipoinmuebles;
    }

    @Override
    @Transactional
    public void Delete(TipoInmueble tipoInmueble) {
        entityManager.remove(tipoInmueble);
    }

    @Override
    @Transactional
    public int Add(TipoInmueble tipoInmueble) {
        entityManager.persist(tipoInmueble);
        return tipoInmueble.getIdtipoinmueble();
    }

    @Override
    public TipoInmueble GetById(int idtipoinmuebleeditable) {
        TypedQuery<TipoInmueble> query = entityManager.createQuery("FROM TipoInmueble WHERE idtipoinmueble=:idtipoinmuebleeditable", TipoInmueble.class);
        query.setParameter("idtipoinmuebleeditable", idtipoinmuebleeditable);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(TipoInmueble tipoInmueble) {
    entityManager.merge(tipoInmueble);
    }

}
