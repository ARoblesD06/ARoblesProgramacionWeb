/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.Controller;

import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.TipoInmuebleDAOImplementation;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.TipoInmueble;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Inmobiliaria")
public class TipoInmuebleController {

    private TipoInmuebleDAOImplementation tipoInmuebleDAOImplementation;

    @Autowired//Inyeccion de dependencias
    public TipoInmuebleController(TipoInmuebleDAOImplementation tipoInmuebleDAOImplementation) {
        this.tipoInmuebleDAOImplementation = tipoInmuebleDAOImplementation;
    }

    @GetMapping("/ListadoTipoInmueble")
    public String ListadoTipoInmueble(Model model) {
        List<TipoInmueble> tipoinmuebles = tipoInmuebleDAOImplementation.GetAll();
        model.addAttribute("tipoinmuebles", tipoinmuebles);
        return "ListadoTipoInmueble";
    }

//    @GetMapping("/add")
//    public String Add(Model model) {
//        model.addAttribute("TipoInmueble", new TipoInmueble());
//        return "FormularioTipo";
//    }
    @GetMapping("/form/{idtipoinmueble}")
    public String Add(@PathVariable int idtipoinmueble, Model model) {
        if (idtipoinmueble == 0) {
            model.addAttribute("TipoInmueble", new TipoInmueble());
            return "FormularioTipo";
        } else {
            TipoInmueble tipoInmueble = tipoInmuebleDAOImplementation.GetById(idtipoinmueble);
            model.addAttribute("TipoInmueble", tipoInmueble);
            return "FormularioTipo";
        }

    }

    @PostMapping("addtipoinmueble")
    public String Add(@ModelAttribute TipoInmueble tipoinmueble) {
        tipoInmuebleDAOImplementation.Add(tipoinmueble);
        return "redirect:/Inmobiliaria/ListadoTipoInmueble";

    }

    @GetMapping("/eliminar/{idtipoinmuble}")
    public String Delete(@PathVariable int idtipoinmuble, Model model) {
        TipoInmueble tipoInmueble = tipoInmuebleDAOImplementation.GetById(idtipoinmuble);
        model.addAttribute("tipoinmuble", tipoInmueble);
        tipoInmuebleDAOImplementation.Delete(tipoInmueble);
        return "redirect:/Inmobiliaria/ListadoTipoInmueble";
    }
    
    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("tipoinmuble") TipoInmueble tipoInmueble, Model model){
        tipoInmuebleDAOImplementation.Update(tipoInmueble);
        return "redirect:/Inmobiliaria/ListadoTipoInmueble";
    }
}
