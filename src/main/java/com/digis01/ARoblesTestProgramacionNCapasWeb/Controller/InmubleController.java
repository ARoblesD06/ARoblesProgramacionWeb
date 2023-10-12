package com.digis01.ARoblesTestProgramacionNCapasWeb.Controller;

import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.InmuebleDAOImplementation;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Inmueble;
import jakarta.validation.Valid;
import java.util.ArrayList;
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
@RequestMapping("/Inmueble")
public class InmubleController {

    private InmuebleDAOImplementation inmuebleDAOImplementation;

    @GetMapping("/ListadoInmueble")
    public String ListadoInmueble(Model model) {
        
        List<Inmueble> inmuebles = inmuebleDAOImplementation.GetAll();
        model.addAttribute("inmuebles", inmuebles);
        return "ListadoInmueble";
    }

    @GetMapping("/form/{idinmueble}")
    public String Add(@PathVariable int idinmueble, Model model) {

        if (idinmueble == 0) {
            model.addAttribute("Inmueble", new Inmueble());
            return "InmuebleForm";
        } else {
            Inmueble inmueble = inmuebleDAOImplementation.GetById(idinmueble);
            model.addAttribute("inmueble", inmueble);
            return "InmuebleForm";
        }
    }
    
     @PostMapping("/form")
    public String Add(@ModelAttribute Inmueble inmueble) {
        inmuebleDAOImplementation.Add(inmueble);
        return "redirect:/Inmueble/ListadoInmueble";
    }   
    @Autowired
    public InmubleController(InmuebleDAOImplementation inmuebleDAOImplementation) {
        this.inmuebleDAOImplementation = inmuebleDAOImplementation;
    }

    @GetMapping("/eliminar/{idinmueble}")
    public String Delete(@PathVariable int idinmueble, Model model) {
        Inmueble inmueble = inmuebleDAOImplementation.GetById(idinmueble);
        model.addAttribute("inmueble", inmueble);
        inmuebleDAOImplementation.Delete(inmueble);
        return "redirect:/Inmueble/ListadoInmueble";
    }
    
//      @PostMapping("/form")
//  public String Update(@Valid @ModelAttribute("inmueble") Inmueble inmueble, Model model){
//        inmuebleDAOImplementation.Update(inmueble);
//        return "redirect:/Inmueble/ListadoInmueble";
//    }
    
}
