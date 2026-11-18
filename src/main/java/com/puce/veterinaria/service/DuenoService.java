package com.puce.veterinaria.service;

import com.puce.veterinaria.model.Dueno;
import com.puce.veterinaria.repository.DuenoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenoService {
    private DuenoRepository duenoRepository;

    public DuenoService(DuenoRepository duenoRepository){
        this.duenoRepository = duenoRepository;
    }

    //leer Todos
    public List<Dueno> traerTodos(){
        return duenoRepository.findAll();
    }

    //Traer Uno
    public Optional<Dueno> traerUno(int id){
        return duenoRepository.findById(id);
    }

    //Crear Uno
    public Dueno  guardar (Dueno dueno){
        return duenoRepository.save(dueno);
    }

    //EDITAR
    public Optional <Dueno> editar(int id, Dueno duenoActualizado){
        return duenoRepository.findById(id)
                .map( duenoExiste ->{
                    duenoExiste.setId( duenoActualizado.getId());
                    duenoExiste.setNombre( duenoActualizado.getNombre());
                    duenoExiste.setCelular( duenoActualizado.getCelular());
                    duenoExiste.setDireccion( duenoActualizado.getDireccion());



                    return duenoRepository.save( duenoExiste);
                });
    }
}
