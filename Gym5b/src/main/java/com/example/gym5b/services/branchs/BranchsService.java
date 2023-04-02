package com.example.gym5b.services.branchs;

import com.example.gym5b.models.branchs.Branchs;
import com.example.gym5b.models.branchs.BranchsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BranchsService {

    @Autowired
    private BranchsRepository branchsRepository;

    //CRUD OPERATIONS FOR EXERCISES <3 <3 <3

    //CREATE
    public Branchs addBranch(Branchs branchs){
        branchs.setId_branch(UUID.randomUUID().toString().split("-")[0]);
        return branchsRepository.addBranch(
                branchs.getName(),
                branchs.getAddress(),
                branchs.getPhone()
        );
    }

    //READ
    public Branchs findBranchByName(String name){
        return branchsRepository.findBranchByName(name);
    }

    public Branchs findAllBranchs(){
        return branchsRepository.findAllBranchs();
    }

    public Branchs findBranchsByAsc(){
        return branchsRepository.findBranchsByAsc();
    }

    public Branchs findBranchsByDesc(){
        return branchsRepository.findBranchsByDesc();
    }

    //UPDATE
    //Actualiza el ejercicio por el nombre del ejercicio y los datos del ejercicio que se le pasan como parametro
    //El nombre del ejercicio que se le pasa como parametro es el que se va a actualizar

    public Branchs updateBranch(Branchs branchsUpdate){
        Branchs branchs = branchsRepository.findBranchByName(branchsUpdate.getName());
        branchs.setAddress(branchsUpdate.getAddress());
        branchs.setPhone(branchsUpdate.getPhone());
        return branchsRepository.updateBranchByName(
                branchs.getName(),
                branchs.getAddress(),
                branchs.getPhone()
        );
    }

    //DELETE
    public Branchs deleteBranchByName(String name){
        return branchsRepository.deleteBranchByName(name);
    }
}
