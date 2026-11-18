package com.puce.veterinaria.controller;


import com.puce.veterinaria.model.Dueno;
import com.puce.veterinaria.model.Mascota;
import com.puce.veterinaria.service.DuenoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/dueno")
public class DuenoController {
    private DuenoService duenoService;

    public DuenoController( DuenoService duenoService){
        this.duenoService = duenoService;
    }

    //traerTodos
    @GetMapping
    public List<Dueno> verTodos(){
        return duenoService.traerTodos();
    }

    //Traer Uno
    @GetMapping("/{id}")
    public ResponseEntity<Dueno> traerUno(@PathVariable int id){
        return duenoService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Dueno> guardar(@RequestBody Dueno dueno){
        Dueno nuevoDueno = duenoService.guardar(dueno);
        return new ResponseEntity<>(nuevoDueno, HttpStatus.CREATED);
    }

    //EDITAR
    @PutMapping("/{id}")
    public ResponseEntity<Dueno> editar(@PathVariable int id, @RequestBody Dueno dueno){
        return duenoService.editar(id, dueno)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
