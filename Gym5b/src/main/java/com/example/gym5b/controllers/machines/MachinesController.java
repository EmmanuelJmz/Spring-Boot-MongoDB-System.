package com.example.gym5b.controllers.machines;

import com.example.gym5b.models.machines.Machines;
import com.example.gym5b.services.machines.MachinesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/gym")
public class MachinesController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MachinesService machinesService;

    @PostMapping("/addMachine")
    @ResponseStatus(HttpStatus.CREATED)
    public Machines addMachine(@RequestBody Machines machines){
        logger.info("Creando la máquina: {}...", machines.getName());
        return machinesService.addMachine(machines);
    }

    @GetMapping("/machines")
    public List<Machines> getAllMachines(){
        logger.info("Obteniendo todas las máquinas...");
        return machinesService.findAllMachines();
    }

    @GetMapping("/machines/{name}")
    public Machines findMachineByName(@PathVariable String name){
        logger.info("Obteniendo la máquina: {}...", name);
        return machinesService.findMachineByName(name);
    }

    @GetMapping("/machinesDesc/")
    public List<Machines> findMachinesByDesc(){
        logger.info("Obteniendo las máquinas ordenadas por nombre descendente...");
        return machinesService.findMachinesByDesc();
    }

    @GetMapping("/machinesAsc/")
    public List<Machines> findMachinesByAsc(){
        logger.info("Obteniendo las máquinas ordenadas por nombre ascendente...");
        return machinesService.findMachinesByAsc();
    }

    @GetMapping("/machinesQuantityDesc/")
    public List<Machines> findMachinesByQuantityDesc(){
        logger.info("Obteniendo las máquinas ordenadas por cantidad descendente...");
        return machinesService.findMachinesByQuantityDesc();
    }

    @GetMapping("/machinesQuantityAsc/")
    public List<Machines> findMachinesByQuantityAsc(){
        logger.info("Obteniendo las máquinas ordenadas por cantidad ascendente...");
        return machinesService.findMachinesByQuantityAsc();
    }

    @PutMapping("/updateMachine/{name}")
    public Machines updateMachine(@RequestBody Machines machines){
        logger.info("Actualizando la máquina: {}...", machines.getName());
        return machinesService.updateMachine(machines);
    }
    
    @DeleteMapping("/deleteMachine/{name}")
    public void deleteMachine(@PathVariable String name){
        logger.info("Eliminando la máquina: {}...", name);
        machinesService.deleteMachineByName(name);
    }
}
