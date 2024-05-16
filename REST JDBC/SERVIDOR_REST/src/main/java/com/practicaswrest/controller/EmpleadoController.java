package com.practicaswrest.controller;

import com.practicaswrest.entity.Empleado;
import com.practicaswrest.service.EmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoservice;
    
    @GetMapping
    public List<Empleado> listar(){
        return empleadoservice.listar();
    }
    
    @PostMapping
    public Empleado insertar(@RequestBody Empleado emp){
        return empleadoservice.insertar(emp);
    }
    
    @PutMapping
    public Empleado actualizar(@RequestBody Empleado emp){
        return empleadoservice.actualizar(emp);
    }
    
    @DeleteMapping
    public void eliminar(@RequestBody Empleado emp){
        empleadoservice.eliminar(emp);
    }
    
}