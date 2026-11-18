package com.puce.veterinaria.service;

import com.puce.veterinaria.model.Mascota;
import com.puce.veterinaria.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    private MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository){
        this.mascotaRepository = mascotaRepository;
    }

    //leer Todos
    public List<Mascota> traerTodos(){
        return mascotaRepository.findAll();
    }

    //Traer Uno
    public Optional<Mascota> traerUno(int id){
        return mascotaRepository.findById(id);
    }

    //Crear Uno
    public Mascota  guardar (Mascota mascota){
        return mascotaRepository.save(mascota);
    }

    //EDITAR
    public Optional <Mascota> editar(int id, Mascota mascotaActualizado){
        return mascotaRepository.findById(id)
                .map( mascotaExiste ->{
                    mascotaExiste.setId( mascotaActualizado.getId());
                    mascotaExiste.setNombre(mascotaActualizado.getNombre());
                    mascotaExiste.setEspecie(mascotaActualizado.getEspecie());
                    mascotaExiste.setEdad(mascotaActualizado.getEdad());
                    mascotaExiste.setDueno(mascotaActualizado.getDueno());


                    return mascotaRepository.save( mascotaExiste);
                });
    }

}
