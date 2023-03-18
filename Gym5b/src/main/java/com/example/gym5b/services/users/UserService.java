package com.example.gym5b.services.users;

import com.example.gym5b.models.users.UserRepository;
import com.example.gym5b.models.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //CRUD OPERATIONS FOR USERS <3 <3 <3

    //CREATE
    public Users addUser(Users users){
        users.setId_user(UUID.randomUUID().toString().split("-")[0]);
        return userRepository.save(users);
    }

    //READ
    public List<Users> findAllUsers(){
        return userRepository.findAll();
    }

    public Users findUserById(String id){
        return userRepository.findById(id).get();
    }

    public List<Users> findUserByName(String name){
        return userRepository.findUserByName(name);
    }

    public List<Users> findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    //UPDATE
    //Actualiza el usuario por el id del usuario y los datos del usuario que se le pasan como parametro
    //El id del usuario que se le pasa como parametro es el que se va a actualizar

    public Users updateUser(Users usersUpdate){
        Users existingUsers = userRepository.findById(usersUpdate.getId_user()).get();
        existingUsers.setName(usersUpdate.getName());
        existingUsers.setLast_name(usersUpdate.getLast_name());
        existingUsers.setEmail(usersUpdate.getEmail());
        existingUsers.setPassword(usersUpdate.getPassword());
        return userRepository.save(existingUsers);
    }

    //DELETE
    public String deleteUser(String id){
        userRepository.deleteById(id);
        return id + "Usuario eliminado :)";
    }
}
