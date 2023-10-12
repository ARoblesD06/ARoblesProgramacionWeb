/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.RestController;

import com.digis01.ARoblesTestProgramacionNCapasWeb.Entity.NumerosOperacion;
import com.digis01.ARoblesTestProgramacionNCapasWeb.Entity.Respuesta;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/apiAxel")
public class DemoRestController {
   
//    @GetMapping("/saludo")
//    public String holaMundo() {
//        return "Hola Mundo desde Servicio";
//    }
    @GetMapping("/saludo")
    public Map<String, Object> Saludo (@RequestBody NumerosOperacion numerosOperacion) {
        Map<String, Object> response = new  HashMap<>();
        response.put("Saludo", "Hola mundo con JSON" +numerosOperacion.getNombre() );
        return response;
    }
    
    
    
    @PostMapping("/suma")
    public Respuesta suma(@RequestBody NumerosOperacion numerosOperacion){
        
        return new Respuesta(numerosOperacion.getNumero1() + numerosOperacion.getNumero2());
    }
    
    @PostMapping("/multi")
    public Respuesta multiplicacion(@RequestBody NumerosOperacion numerosOperacion){
        
        return new Respuesta(numerosOperacion.getNumero1() * numerosOperacion.getNumero2());
    }
    
    @PostMapping("/div")
    public Respuesta division(@RequestBody NumerosOperacion numerosOperacion){
        
        return new Respuesta(numerosOperacion.getNumero1() / numerosOperacion.getNumero2());
    }
    
    @PostMapping("/resta")
    public Respuesta resta(@RequestBody NumerosOperacion numerosOperacion){
        
        return new Respuesta(numerosOperacion.getNumero1() - numerosOperacion.getNumero2());
    }
    
}
