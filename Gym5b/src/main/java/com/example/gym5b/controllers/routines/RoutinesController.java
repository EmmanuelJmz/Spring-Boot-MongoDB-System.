package com.example.gym5b.controllers.routines;

import com.example.gym5b.models.routines.Routines;
import com.example.gym5b.services.routines.RoutinesService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/gym")
public class RoutinesController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoutinesService routinesService;

    @PostMapping("/addRoutine")
    @ResponseStatus(HttpStatus.CREATED)
    public Routines addRoutine(@RequestBody Routines routines){
        logger.info("Creando la rutina: {}...", routines.getName());
        return routinesService.addRoutine(routines);
    }

    @GetMapping("/routines")
    public Routines getAllRoutines(){
        logger.info("Obteniendo todas las rutinas...");
        return routinesService.findAllRoutines();
    }

    @GetMapping("/routines/{name}")
    public Routines findRoutineByName(@PathVariable String name){
        logger.info("Obteniendo la rutina: {}...", name);
        return routinesService.findRoutineByName(name);
    }

    @GetMapping("/routinesDesc/")
    public Routines findRoutinesByDesc(){
        logger.info("Obteniendo las rutinas ordenadas por nombre descendente...");
        return routinesService.findRoutinesByDesc();
    }

    @GetMapping("/routinesAsc/")
    public Routines findRoutinesByAsc(){
        logger.info("Obteniendo las rutinas ordenadas por nombre ascendente...");
        return routinesService.findRoutinesByAsc();
    }

    @GetMapping("/findRoutinesByTypeAsc/")
    public Routines findRoutinesByTypeAsc(){
        logger.info("Obteniendo las rutinas ordenadas por tipo ascendente...");
        return routinesService.findRoutinesByTypeAsc();
    }

    @GetMapping("/findRoutinesByTypeDesc/")
    public Routines findRoutinesByTypeDesc(){
        logger.info("Obteniendo las rutinas ordenadas por tipo descendente...");
        return routinesService.findRoutinesByTypeDesc();
    }

    @PutMapping("/updateRoutine/{name}")
    public Routines updateRoutine(@RequestBody Routines routines){
        logger.info("Actualizando la rutina: {}...", routines.getName());
        return routinesService.updateRoutine(routines);
    }

    @DeleteMapping("/deleteRoutine/{name}")
    public Routines deleteRoutineByName(@PathVariable String name){
        logger.info("Eliminando la rutina: {}...", name);
        return routinesService.deleteRoutineByName(name);
    }
}
