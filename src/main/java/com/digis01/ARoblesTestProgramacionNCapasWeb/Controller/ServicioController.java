/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.Controller;

import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.ServicioDAOImplementation;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Servicio;
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
@RequestMapping("/Servicios")
public class ServicioController {

    private ServicioDAOImplementation servicioDAOImplementation;

    @Autowired
    public ServicioController(ServicioDAOImplementation servicioDAOImplementation) {
        this.servicioDAOImplementation = servicioDAOImplementation;
    }

    @GetMapping("/ListadoServicio")
    public String ListadoTipoInmueble(Model model) {
        List<Servicio> servicios = servicioDAOImplementation.GetAll();
        model.addAttribute("servicios", servicios);
        return "ListadoServicios";
    }

//    @GetMapping("/add")
//    public String Add(Model model) {
//        model.addAttribute("Servicio", new Servicio());
//        return "ServicioForm";
//    }
    @GetMapping("/form/{idservicio}")
    public String Add(@PathVariable int idservicio, Model model) {

        if (idservicio == 0) {
            model.addAttribute("Servicio", new Servicio());
            return "ServicioForm";
        } else {
            Servicio servicio = servicioDAOImplementation.GetById(idservicio);
            model.addAttribute("Servicio", servicio);
            return "ServicioForm";
        }

    }

    @PostMapping("addservicio")
    public String Add(@ModelAttribute Servicio servicio) {
        servicioDAOImplementation.add(servicio);
        return "redirect:/Servicios/ListadoServicio";
    }

    @GetMapping("/eliminar/{idservicio}")
    public String Delete(@PathVariable int idservicio, Model model) {
        Servicio servicio = servicioDAOImplementation.GetById(idservicio);
        model.addAttribute("servicio", servicio);
        servicioDAOImplementation.Delete(servicio);
        return "redirect:/Servicios/ListadoServicio";
    }

  @PostMapping("/form")
  public String Update(@Valid @ModelAttribute("servicio") Servicio servicio, Model model){
        servicioDAOImplementation.update(servicio);
        return "redirect:/Servicios/ListadoServicio";
    }
}
