package com.example.gym5b.services.machines;

import com.example.gym5b.models.machines.Machines;
import com.example.gym5b.models.machines.MachinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MachinesService {
    
    @Autowired
    private MachinesRepository machinesRepository;
    
    //CRUD OPERATIONS FOR MACHINES <3 <3 <3
    
    //CREATE
    public Machines addMachine(Machines machines){
        machines.setId_machine(UUID.randomUUID().toString().split("-")[0]);
        return machinesRepository.addMachine(
                machines.getName(),
                machines.getDescription(),
                machines.getQuantity());
    }
    
    //READ
    public Machines findMachineByName(String name){
        return machinesRepository.findMachineByName(name);
    }

    public List<Machines> findAllMachines(){
        return machinesRepository.findAllMachines();
    }

    public List<Machines> findMachinesByAsc(){
        return machinesRepository.findMachinesByAsc();
    }

    public List<Machines> findMachinesByDesc(){
        return machinesRepository.findMachinesByDesc();
    }

    public List<Machines> findMachinesByQuantityAsc(){
        return machinesRepository.findMachinesByQuantityAsc();
    }

    public List<Machines> findMachinesByQuantityDesc(){
        return machinesRepository.findMachinesByQuantityDesc();
    }

    //UPDATE
    //Actualiza la maquina por el nombre de la maquina y los datos de la maquina que se le pasan como parametro
    //El nombre de la maquina que se le pasa como parametro es el que se va a actualizar

    public Machines updateMachine(Machines machinesUpdate){
        Machines existingMachines = machinesRepository.findMachineByName(machinesUpdate.getName());
        existingMachines.setName(machinesUpdate.getName());
        existingMachines.setDescription(machinesUpdate.getDescription());
        existingMachines.setQuantity(machinesUpdate.getQuantity());
        return machinesRepository.updateMachineByName(
                existingMachines.getName(),
                existingMachines.getDescription(),
                existingMachines.getQuantity()
        );
    }

    //DELETE
    public Machines deleteMachineByName(String name){
        return machinesRepository.deleteMachineByName(name);
    }
}
