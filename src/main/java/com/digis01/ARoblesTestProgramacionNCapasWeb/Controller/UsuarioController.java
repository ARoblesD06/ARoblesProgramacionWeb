/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.Controller;

import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.ColoniaDAOImplementation;
import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.DireccionDAOImplementation;
import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.EstadoDAOImplementatiton;
import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.MunicipioDAOImplementation;
import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.PaisDAOImplementatio;
import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.RolDAOImplementation;
import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Colonia;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Direccion;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Estado;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Municipio;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Pais;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Rol;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Usuario;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.UsuarioDireccion;
import com.digis01.ARoblesTestProgramacionNCapasWeb.Util.Util;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {
    
    private UsuarioDAOImplementation usuarioDAOImplementation;
    private DireccionDAOImplementation direccionDAOImplementation;
    private RolDAOImplementation rolDAOImplementation;
    private ColoniaDAOImplementation coloniaDAOImplementation;
    private PaisDAOImplementatio paisDAOImplementation;
    private EstadoDAOImplementatiton estadoDAOImplementatiton;
    private MunicipioDAOImplementation municipioDAOImplementation;
    
    @Autowired//INYECCION DE DEPENDENCIAS
    public UsuarioController(UsuarioDAOImplementation usuarioDAOImplementation, DireccionDAOImplementation direccionDAOImplementation, RolDAOImplementation rolDAOImplementation, ColoniaDAOImplementation coloniaDAOImplementation, PaisDAOImplementatio paisDAOImplementation, EstadoDAOImplementatiton estadoDAOImplementatiton, MunicipioDAOImplementation municipioDAOImplementation) {
        this.usuarioDAOImplementation = usuarioDAOImplementation;
        this.direccionDAOImplementation = direccionDAOImplementation;
        this.rolDAOImplementation = rolDAOImplementation;
        this.coloniaDAOImplementation = coloniaDAOImplementation;
        this.paisDAOImplementation = paisDAOImplementation;
        this.estadoDAOImplementatiton = estadoDAOImplementatiton;
        this.municipioDAOImplementation = municipioDAOImplementation;
    }
    
    @GetMapping("/listado")
    private String listadoAlumnos(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("");
        usuario.setApellidopaterno("");
        usuario.setApellidomaterno("");
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario); // recuperación de datos
        model.addAttribute("usuarios", usuarios); //envío de datos para HTML
        model.addAttribute("usuariobusqueda", new Usuario());
        List<Direccion> direcciones = direccionDAOImplementation.GetAll();
        model.addAttribute("direcciones", direcciones);

        //model.addAttribute("direcciones", direcciones);
//        List<Municipio> municipios = municipioDAOImplementation.GetAll();
//        model.addAttribute("municipios", municipios);
        return "listadoUsuarios";
    }
    
    @PostMapping("/listado")
    private String listadoAlumnos(Model model, @ModelAttribute("usuariobusqueda") Usuario usuariobusqueda) {
        
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuariobusqueda); // recuperación de datos
        model.addAttribute("usuarios", usuarios); //envío de datos para HTML
        model.addAttribute("usuariobusqueda", usuariobusqueda); //envío de datos para HTML

        List<Direccion> direcciones = direccionDAOImplementation.GetAll();
        model.addAttribute("direcciones", direcciones);
        
        return "listadoUsuarios";
    }
    
    @GetMapping("/form/{idusuario}")
    public String Form(@PathVariable int idusuario, Model model) {
        List<Rol> roles = rolDAOImplementation.GetAll();
        model.addAttribute("roles", roles);
        List<Pais> paises = paisDAOImplementation.GetAll();//Listado de PAIS 
        model.addAttribute("paises", paises);
        //List<Estado> estados = estadoDAOImplementatiton.GetAll();//Listado de Estados
        //List<Municipio> municipios = municipioDAOImplementation.GetAll();
        //List<Colonia> colonias = coloniaDAOImplementation.GetAll();//Listado de Municipio
        if (idusuario == 0) {
            model.addAttribute("Usuariodireccion", new UsuarioDireccion());
            return "formUsuarioEditable";
        } else {
            UsuarioDireccion usuariodireccion = new UsuarioDireccion();
            Usuario usuario = usuarioDAOImplementation.GetById(idusuario);
            
            usuariodireccion.setUsuario(usuarioDAOImplementation.GetById(idusuario));
            usuariodireccion.setDireccion(direccionDAOImplementation.GetById(idusuario));
            model.addAttribute("Usuariodireccion", usuariodireccion);
            model.addAttribute("imagenUsuario", usuario.getImagen());
            model.addAttribute("estados", estadoDAOImplementatiton.GetByIdPais(usuariodireccion.getDireccion().getColonia().getMunicipio().getEstado().getPais().getIdpais()));
            model.addAttribute("municipios", municipioDAOImplementation.GetByIdEstado(usuariodireccion.getDireccion().getColonia().getMunicipio().getEstado().getIdestado()));
            model.addAttribute("colonias", coloniaDAOImplementation.GetByIdMunicipio(usuariodireccion.getDireccion().getColonia().getMunicipio().getIdmunicipio()));

            if (usuariodireccion.getDireccion().getColonia() != null) {
            model.addAttribute("estados", estadoDAOImplementatiton.GetByIdPais(usuariodireccion.getDireccion().getColonia().getMunicipio().getEstado().getPais().getIdpais()));
            }
            return "formUsuarioEditable";
        }
        
    }
    
    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("usuariodireccion") BindingResult bindingResult, UsuarioDireccion usuariodireccion,
            @RequestParam("imagenFile") MultipartFile imagenFile, Model model) {
// actualización      
        if (bindingResult.hasErrors()) {
            
            model.addAttribute("usuariodireccion", usuariodireccion);
            return "formUsuarioEditable";
        }
        
        String imagenBase64 = Util.convertirImagenBase64(imagenFile);
        usuariodireccion.getUsuario().setImagen(imagenBase64);
        
        if (usuariodireccion.getUsuario().getIdusuario() > 0) {
            usuarioDAOImplementation.Update(usuariodireccion.getUsuario());
        } else {
            usuariodireccion.getUsuario().setStatus(1);
            int idusuario = usuarioDAOImplementation.Add(usuariodireccion.getUsuario());
            //usuarioDAOImplementation.Add(usuario);
            //usuariodireccion.setDireccion(direccion);
            usuariodireccion.getDireccion().setUsuario(new Usuario(idusuario));
            direccionDAOImplementation.Add(usuariodireccion.getDireccion());
        }
        return "redirect:/Usuario/listado";
    }
    
    @GetMapping("/eliminar/{idusuario}")
    public String Delete(@PathVariable int idusuario, Model model) {
        Usuario usuario = usuarioDAOImplementation.GetById(idusuario);
        model.addAttribute("usuario", usuario);
        usuarioDAOImplementation.Delete(usuario);
        return "redirect:/Usuario/listado";
    }
    
    @GetMapping("/GetEstadoByIdPais")
    @ResponseBody
    public List<Estado> GetEstadoByIdPais(@RequestParam("IdPais") int IdPais) {
        List<Estado> estados = estadoDAOImplementatiton.GetByIdPais(IdPais); // Obtiene los datos del servicio
        return estados;
    }
    
    @GetMapping("/GetMunicipioByIdEstado")
    @ResponseBody
    public List<Municipio> GetMunicipioByIdEstado(@RequestParam("IdEstado") int IdEstado) {
        List<Municipio> municipios = municipioDAOImplementation.GetByIdEstado(IdEstado); // Obtiene los datos del servicio
        return municipios;
    }
    
    @GetMapping("/GetColoniaByIdMunicipio")
    @ResponseBody
    public List<Colonia> GetColoniaByIdMunicipio(@RequestParam("IdMunicipio") int IdMunicipio) {
        List<Colonia> colonias = coloniaDAOImplementation.GetByIdMunicipio(IdMunicipio); // Obtiene los datos del servicio
        return colonias;
    }
    
    @GetMapping("/changeStatus")
    @ResponseBody
    public void changeStatus(@RequestParam("idusuario") int idusuario, @RequestParam("status") boolean status) {
        usuarioDAOImplementation.ChangeStatus(idusuario, status);
    }

    //    @GetMapping("/add")
//    public String Add(Model model) {
//        model.addAttribute("Usuario", new Usuario());
//        return "formusuario";
//    }
//    @PostMapping("addusuario")
//    public String Add(@ModelAttribute Usuario usuario) {
//
//        //la logica necesaria para enviar dicha información a DAO
//        usuarioDAOImplementation.Add(usuario);
//
//        return "redirect:/Usuario/listado";
//
//    }
}
