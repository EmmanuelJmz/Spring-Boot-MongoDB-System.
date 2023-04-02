package com.example.gym5b.controllers.branchs;

import com.example.gym5b.models.branchs.Branchs;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.gym5b.services.branchs.BranchsService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/gym")
public class BranchController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BranchsService branchService;

    @PostMapping("/addBranch")
    @ResponseStatus(HttpStatus.CREATED)
    public Branchs addBranch(@RequestBody Branchs branch){
        logger.info("Creando la sucursal: {}...", branch.getName());
        return branchService.addBranch(branch);
    }

    @GetMapping("/branchs")
    public Branchs getAllBranchs(){
        logger.info("Obteniendo todas las sucursales...");
        return branchService.findAllBranchs();
    }

    @GetMapping("/branchs/{name}")
    public Branchs findBranchByName(@PathVariable String name){
        logger.info("Obteniendo la sucursal: {}...", name);
        return branchService.findBranchByName(name);
    }

    @GetMapping("/branchsDesc/")
    public Branchs findBranchsByDesc(){
        logger.info("Obteniendo las sucursales ordenadas por nombre descendente...");
        return branchService.findBranchsByDesc();
    }

    @GetMapping("/branchsAsc/")
    public Branchs findBranchsByAsc(){
        logger.info("Obteniendo las sucursales ordenadas por nombre ascendente...");
        return branchService.findBranchsByAsc();
    }

    @PutMapping("/updateBranch/{name}")
    public Branchs updateBranch(@RequestBody Branchs branch){
        logger.info("Actualizando la sucursal: {}...", branch.getName());
        return branchService.updateBranch(branch);
    }

    @DeleteMapping("/deleteBranch/{name}")
    public void deleteBranchByName(@PathVariable String name){
        logger.info("Eliminando la sucursal: {}...", name);
        branchService.deleteBranchByName(name);
    }
}
