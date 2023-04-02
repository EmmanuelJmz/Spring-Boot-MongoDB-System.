package com.example.gym5b.controllers.instructors;

import com.example.gym5b.models.instructors.Instructors;
import com.example.gym5b.services.instructors.InstructorsService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/gym")
public class InstructorsController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private InstructorsService instructorsService;

    @PostMapping("/addInstructor")
    @ResponseStatus(HttpStatus.CREATED)
    public Instructors addInstructor(@RequestBody Instructors instructors){
        logger.info("Creando el instructor: {}...", instructors.getName());
        return instructorsService.addInstructor(instructors);
    }

    @GetMapping("/instructors")
    public List<Instructors> getAllInstructors(){
        logger.info("Obteniendo todos los instructores...");
        return instructorsService.findAllInstructors();
    }

    @GetMapping("/instructors/{name}")
    public Instructors findInstructorByName(@PathVariable String name){
        logger.info("Obteniendo el instructor: {}...", name);
        return instructorsService.findInstructorByName(name);
    }

    @GetMapping("/instructorsDesc/")
    public List<Instructors> findInstructorsByDesc(){
        logger.info("Obteniendo los instructores ordenados por nombre descendente...");
        return instructorsService.findInstructorsByDesc();
    }

    @GetMapping("/instructorsAsc/")
    public List<Instructors> findInstructorsByAsc(){
        logger.info("Obteniendo los instructores ordenados por nombre ascendente...");
        return instructorsService.findInstructorsByAsc();
    }

    @GetMapping("/findInstructorsByAgeAsc/")
    public List<Instructors> findInstructorsByAgeAsc(){
        logger.info("Obteniendo los instructores ordenados por edad ascendente...");
        return instructorsService.findInstructorsByAgeAsc();
    }

    @GetMapping("/findInstructorsByAgeDesc/")
    public List<Instructors> findInstructorsByAgeDesc(){
        logger.info("Obteniendo los instructores ordenados por edad descendente...");
        return instructorsService.findInstructorsByAgeDesc();
    }

    @PutMapping("/updateInstructor/{name}")
    public Instructors updateInstructor(@RequestBody Instructors instructors){
        logger.info("Actualizando el instructor: {}...", instructors.getName());
        return instructorsService.updateInstructor(instructors);
    }

    @DeleteMapping("/deleteInstructor/{name}")
    public void deleteInstructor(@PathVariable String name){
        logger.info("Eliminando el instructor: {}...", name);
        instructorsService.deleteInstructorByName(name);
    }

}
