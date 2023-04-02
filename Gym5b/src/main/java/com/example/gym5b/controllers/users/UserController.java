package com.example.gym5b.controllers.users;

import com.example.gym5b.models.users.UserRepository;
import com.example.gym5b.models.users.Users;
import com.example.gym5b.services.users.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public Users addUser2(@RequestBody Users users){
        logger.info("Creando al usuario: {}...", users.getName());
        return userService.addUser2(users);
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        logger.info("Obteniendo todos los usuarios...");
        return userService.findAllUsers();
    }

    @GetMapping("/usersName/{name}")
    public Users findUserByName(@PathVariable String name){
        logger.info("Obteniendo al usuario: {}...", name);
        return userService.findUserByName(name);
    }

    @GetMapping("/usersEmail/{email}")
    public List<Users> getUserByEmail(@PathVariable String email){
        logger.info("Obteniendo al usuario: {}...", email);
        return userService.findUserByEmail(email);
    }

    @GetMapping("/usersDesc/")
    public List<Users> findUsersByDesc(){
        logger.info("Obteniendo los usuarios ordenados por nombre descendente...");
        return userService.findUsersByDesc();
    }

    @GetMapping("/usersAsc/")
    public List<Users> findUsersByAsc(){
        logger.info("Obteniendo los usuarios ordenados por nombre ascendente...");
        return userService.findUsersByAsc();
    }

    @GetMapping("/findUsersByAgeAsc/")
    public List<Users> findUsersByAgeAsc(){
        logger.info("Obteniendo los usuarios ordenados por edad ascendente...");
        return userService.findUsersByAgeAsc();
    }

    @GetMapping("/findUsersByAgeDesc/")
    public List<Users> findUsersByAgeDesc(){
        logger.info("Obteniendo los usuarios ordenados por edad descendente...");
        return userService.findUsersByAgeDesc();
    }

    @PutMapping("/updateUser/{name}")
    public Users updateUser(@PathVariable(value = "name") String name, @RequestBody Users user) {
        Users updatedUser = userService.updateUser(name, user);
        return updatedUser;
    }

    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        userService.deleteUserByEmail(email);
        return ResponseEntity.ok().body("Usuario eliminado correctamente");
    }

    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity<String> deleteAllUsers() {
        userService.deleteAllUsers();
        return ResponseEntity.ok().body("Todos los usuarios han sido eliminados");
    }
}
