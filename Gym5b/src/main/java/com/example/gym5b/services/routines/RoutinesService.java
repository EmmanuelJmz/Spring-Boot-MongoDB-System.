package com.example.gym5b.services.routines;

import com.example.gym5b.models.routines.Routines;
import com.example.gym5b.models.routines.RoutinesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoutinesService {

    @Autowired
    private RoutinesRespository routinesRespository;

    //CRUD OPERATIONS FOR ROUTINES <3 <3 <3

    //CREATE
    public Routines addRoutine(Routines routines){
        routines.setId_routine(UUID.randomUUID().toString().split("-")[0]);
        return routinesRespository.addRoutine(
                routines.getName(),
                routines.getDescription(),
                routines.getType()
        );
    }

    //READ
    public Routines findRoutineByName(String name){
        return routinesRespository.findRoutineByName(name);
    }

    public Routines findAllRoutines(){
        return routinesRespository.findAllRoutines();
    }

    public Routines findRoutinesByAsc(){
        return routinesRespository.findRoutinesByAsc();
    }

    public Routines findRoutinesByDesc(){
        return routinesRespository.findRoutinesByDesc();
    }

    public Routines findRoutinesByTypeAsc(){
        return routinesRespository.findRoutinesByTypeAsc();
    }

    public Routines findRoutinesByTypeDesc(){
        return routinesRespository.findRoutinesByTypeDesc();
    }

    //UPDATE
    //Actualiza la rutina por el nombre de la rutina y los datos de la rutina que se le pasan como parametro
    //El nombre de la rutina que se le pasa como parametro es el que se va a actualizar

    public Routines updateRoutine(Routines routinesUpdate){
        Routines routines = routinesRespository.findRoutineByName(routinesUpdate.getName());
        routines.setDescription(routinesUpdate.getDescription());
        routines.setType(routinesUpdate.getType());
        return routinesRespository.updateRoutineByName(
                routines.getName(),
                routines.getDescription(),
                routines.getType()
        );
    }

    //DELETE
    public Routines deleteRoutineByName(String name){
        return routinesRespository.deleteRoutineByName(name);
    }
}
