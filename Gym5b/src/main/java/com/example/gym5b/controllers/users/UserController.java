package com.example.gym5b.controllers.users;

import com.example.gym5b.models.users.Users;
import com.example.gym5b.services.users.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/gym")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody Users users){
        logger.info("Creando al usuario: {}...", users.getName());
        return userService.addUser(users);
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        logger.info("Obteniendo todos los usuarios...");
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable String id){
        logger.info("Obteniendo al usuario: {}...", id);
        return userService.findUserById(id);
    }

    @GetMapping("/users/{name}")
    public List<Users> findUserByName(@PathVariable String name){
        logger.info("Obteniendo al usuario: {}...", name);
        return userService.findUserByName(name);
    }

    @GetMapping("/users/{email}")
    public List<Users> getUserByEmail(@PathVariable String email){
        logger.info("Obteniendo al usuario: {}...", email);
        return userService.findUserByEmail(email);
    }

    @PutMapping("/users/{id}")
    public Users updateUser(@RequestBody Users users){
        logger.info("Actualizando al usuario: {}...", users.getName());
        return userService.updateUser(users);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable String id){
        logger.info("Eliminando al usuario: {}...", id);
        return userService.deleteUser(id);
    }
}
