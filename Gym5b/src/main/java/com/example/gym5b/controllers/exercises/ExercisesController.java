package com.example.gym5b.controllers.exercises;

import com.example.gym5b.models.exersices.Exercises;
import com.example.gym5b.services.exercises.ExercisesService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/gym")
public class ExercisesController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ExercisesService exercisesService;

    @PostMapping("/addExercise")
    @ResponseStatus(HttpStatus.CREATED)
    public Exercises addExercise(@RequestBody Exercises exercises){
        logger.info("Creando el ejercicio: {}...", exercises.getName());
        return exercisesService.addExercise(exercises);
    }

    @GetMapping("/exercises")
    public Exercises getAllExercises(){
        logger.info("Obteniendo todos los ejercicios...");
        return exercisesService.findAllExercises();
    }

    @GetMapping("/exercises/{name}")
    public Exercises findExerciseByName(@PathVariable String name){
        logger.info("Obteniendo el ejercicio: {}...", name);
        return exercisesService.findExerciseByName(name);
    }

    @GetMapping("/exercisesDesc/")
    public Exercises findExercisesByDesc(){
        logger.info("Obteniendo los ejercicios ordenados por nombre descendente...");
        return exercisesService.findExercisesByDesc();
    }

    @GetMapping("/exercisesAsc/")
    public Exercises findExercisesByAsc(){
        logger.info("Obteniendo los ejercicios ordenados por nombre ascendente...");
        return exercisesService.findExercisesByAsc();
    }

    @GetMapping("/findExercisesByTypeAsc/")
    public Exercises findExercisesByTypeAsc(){
        logger.info("Obteniendo los ejercicios ordenados por tipo ascendente...");
        return exercisesService.findExercisesByTypeAsc();
    }

    @GetMapping("/findExercisesByTypeDesc/")
    public Exercises findExercisesByTypeDesc(){
        logger.info("Obteniendo los ejercicios ordenados por tipo descendente...");
        return exercisesService.findExercisesByTypeDesc();
    }

    @PutMapping("/updateExercise/{name}")
    public Exercises updateExercise(@RequestBody Exercises exercises){
        logger.info("Actualizando el ejercicio: {}...", exercises.getName());
        return exercisesService.updateExercise(exercises);
    }

    @DeleteMapping("/deleteExercise/{name}")
    public void deleteExerciseByName(@PathVariable String name){
        logger.info("Eliminando el ejercicio: {}...", name);
        exercisesService.deleteExerciseByName(name);
    }

}
