package com.example.gym5b.services.exercises;

import com.example.gym5b.models.exersices.Exercises;
import com.example.gym5b.models.exersices.ExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExercisesService {

    @Autowired
    private ExercisesRepository exercisesRepository;

    //CRUD OPERATIONS FOR EXERCISES <3 <3 <3

    //CREATE
    public Exercises addExercise(Exercises exercises){
        exercises.setId_exercise(UUID.randomUUID().toString().split("-")[0]);
        return exercisesRepository.addExercise(
                exercises.getName(),
                exercises.getDescription(),
                exercises.getType()
        );
    }

    //READ
    public Exercises findExerciseByName(String name){
        return exercisesRepository.findExerciseByName(name);
    }

    public Exercises findAllExercises(){
        return exercisesRepository.findAllExercises();
    }

    public Exercises findExercisesByAsc(){
        return exercisesRepository.findExercisesByAsc();
    }

    public Exercises findExercisesByDesc(){
        return exercisesRepository.findExercisesByDesc();
    }

    public Exercises findExercisesByTypeAsc(){
        return exercisesRepository.findExercisesByTypeAsc();
    }

    public Exercises findExercisesByTypeDesc(){
        return exercisesRepository.findExercisesByTypeDesc();
    }

    //UPDATE
    //Actualiza el ejercicio por el nombre del ejercicio y los datos del ejercicio que se le pasan como parametro
    //El nombre del ejercicio que se le pasa como parametro es el que se va a actualizar

    public Exercises updateExercise(Exercises exercisesUpdate){
        Exercises exercises = exercisesRepository.findExerciseByName(exercisesUpdate.getName());
        exercises.setDescription(exercisesUpdate.getDescription());
        exercises.setType(exercisesUpdate.getType());
        return exercisesRepository.updateExerciseByName(
                exercises.getName(),
                exercises.getDescription(),
                exercises.getType()
        );
    }

    //DELETE
    public Exercises deleteExerciseByName(String name){
        return exercisesRepository.deleteExerciseByName(name);
    }
}
