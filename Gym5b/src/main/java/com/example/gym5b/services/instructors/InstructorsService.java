package com.example.gym5b.services.instructors;

import com.example.gym5b.models.instructors.Instructors;
import com.example.gym5b.models.instructors.InstructorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InstructorsService {

    @Autowired
    private InstructorsRepository instructorsRepository;

    //CRUD OPERATIONS FOR INSTRUCTORS <3 <3 <3

    //CREATE
    public Instructors addInstructor(Instructors instructors){
        instructors.setId_user(UUID.randomUUID().toString().split("-")[0]);
        return instructorsRepository.addInstructor(
                instructors.getName(),
                instructors.getLast_name(),
                instructors.getAge(),
                instructors.getEmail(),
                instructors.getPassword()
        );
    }

    //READ
    public Instructors findInstructorByName(String name){
        return instructorsRepository.findInstructorByName(name);
    }

    public List<Instructors> findAllInstructors(){
        return instructorsRepository.findAllInstructors();
    }

    public List<Instructors> findInstructorsByAsc(){
        return instructorsRepository.findInstructorsByAsc();
    }

    public List<Instructors> findInstructorsByDesc(){
        return instructorsRepository.findInstructorsByDesc();
    }

    public List<Instructors> findInstructorsByAgeAsc(){
        return instructorsRepository.findInstructorsByAgeAsc();
    }

    public List<Instructors> findInstructorsByAgeDesc(){
        return instructorsRepository.findInstructorsByAgeDesc();
    }

    //UPDATE
    //Actualiza el instructor por el nombre del instructor y los datos del instructor que se le pasan como parametro
    //El nombre del instructor que se le pasa como parametro es el que se va a actualizar

    public Instructors updateInstructor(Instructors instructorsUpdate){
        Instructors existingInstructors = instructorsRepository.findInstructorByName(instructorsUpdate.getName());
        existingInstructors.setName(instructorsUpdate.getName());
        existingInstructors.setLast_name(instructorsUpdate.getLast_name());
        existingInstructors.setAge(instructorsUpdate.getAge());
        existingInstructors.setEmail(instructorsUpdate.getEmail());
        existingInstructors.setPassword(instructorsUpdate.getPassword());
        return instructorsRepository.updateInstructorByName(
                existingInstructors.getName(),
                existingInstructors.getLast_name(),
                existingInstructors.getAge(),
                existingInstructors.getEmail(),
                existingInstructors.getEmail(),
                existingInstructors.getPassword()
        );
    }

    //DELETE
    public Instructors deleteInstructorByName(String name){
        return instructorsRepository.deleteInstructorByName(name);
    }
}
