/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.DAO;

import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Rol;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Usuario;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public class UsuarioDAOImplementation implements IUsuarioDAO {

    private EntityManager entityManager;

    @Autowired//inyeccion de independencias 
    public UsuarioDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    @Override
//    public List<Usuario> GetAll(Usuario usuario) {
//
//        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE nombre LIKE :nombreusuario AND apellidopaterno LIKE :apellidopaterno AND apellidomaterno LIKE : apellidomaterno", Usuario.class);
//        query.setParameter("nombreusuario", ('%' + usuario.getNombre())+ '%');
//        query.setParameter("apellidopaterno", ('%' + usuario.getApellidopaterno())+ '%');
//        query.setParameter("apellidomaterno", ('%' + usuario.getApellidomaterno())+ '%');        
//        List<Usuario> usuarios = query.getResultList();
//        return usuarios;
//
//    }
    @Override
    public List<Usuario> GetAll(Usuario usuario) {
        String nombre = usuario.getNombre().trim().toLowerCase();
        String apellidoPaterno = usuario.getApellidopaterno().trim().toLowerCase();
        String apellidoMaterno = usuario.getApellidomaterno().trim().toLowerCase();

        TypedQuery<Usuario> query = entityManager.createQuery(
                "FROM Usuario u WHERE TRIM(LOWER(u.nombre)) LIKE :nombreusuario "
                + "AND TRIM(LOWER(u.apellidopaterno)) LIKE :apellidopaterno "
                + "AND TRIM(LOWER(u.apellidomaterno)) LIKE :apellidomaterno", Usuario.class);

        query.setParameter("nombreusuario", '%' + nombre + '%');
        query.setParameter("apellidopaterno", '%' + apellidoPaterno + '%');
        query.setParameter("apellidomaterno", '%' + apellidoMaterno + '%');

        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }
    @Override
    @Transactional
    public int Add(Usuario usuario) {
//        usuario.setFechanacimiento(new Date());
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Rol rol = new Rol();
//        rol.setIdrol(1);
//        usuario.setRol(rol);  
        entityManager.persist(usuario);
        return usuario.getIdusuario();
    }

    @Override
    public Usuario GetById(int idusuarioeditable) {
        //JPQL
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE idusuario=:idusuarioeditable", Usuario.class);
        query.setParameter("idusuarioeditable", idusuarioeditable);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    @Transactional
    public void Delete(Usuario usuario) {
        entityManager.remove(usuario);
    }
    
    @Override
    @Transactional
    public void ChangeStatus(int idusuario, boolean status) {
        Usuario usuario = entityManager.find(Usuario.class, idusuario);
        int statusInt = (status)? 1 : 0;
        usuario.setStatus(statusInt);      
        entityManager.merge(usuario);
    }

}
