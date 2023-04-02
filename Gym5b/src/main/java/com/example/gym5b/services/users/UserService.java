package com.example.gym5b.services.users;

import com.example.gym5b.models.users.UserRepository;
import com.example.gym5b.models.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    //CRUD OPERATIONS FOR USERS <3 <3 <3

    //CREATE
    public Users addUser(Users users){
        users.setId_user(UUID.randomUUID().toString().split("-")[0]);
        return userRepository.save(users);
    }

    public Users addUser2(Users users){
        users.setId_user(UUID.randomUUID().toString().split("-")[0]);
        return userRepository.addUser2(
                users.getName(),
                users.getLast_name(),
                users.getAge(),
                users.getEmail(),
                users.getPassword()
        );
    }

    //READ
    public List<Users> findAllUsers(){
        return userRepository.findAllUsers();
    }

    public Users findUserByName(String name){
        return userRepository.findUserByName(name);
    }

    public List<Users> findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public List<Users> findUsersByAsc(){
        return userRepository.findUsersByAsc();
    }

    public List<Users> findUsersByDesc(){
        return userRepository.findUsersByDesc();
    }

    public List<Users> findUsersByAgeAsc(){
        return userRepository.findUsersByAgeAsc();
    }

    public List<Users> findUsersByAgeDesc(){
        return userRepository.findUsersByAgeDesc();
    }

    //UPDATE
    //Actualiza el usuario por el id del usuario y los datos del usuario que se le pasan como parametro
    //El id del usuario que se le pasa como parametro es el que se va a actualizar

    public Users updateUser(String name, Users usersUpdate){
        Users existingUsers = userRepository.findById(usersUpdate.getId_user()).get();
        existingUsers.setName(usersUpdate.getName());
        existingUsers.setLast_name(usersUpdate.getLast_name());
        existingUsers.setEmail(usersUpdate.getEmail());
        existingUsers.setPassword(usersUpdate.getPassword());
        return userRepository.updateUserByName(
                existingUsers.getId_user(),
                existingUsers.getName(),
                existingUsers.getLast_name(),
                existingUsers.getAge(),
                existingUsers.getEmail(),
                existingUsers.getPassword()
        );
    }

    //DELETE
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    public void deleteAllUsers() {
        userRepository.deleteAllUsers();
    }

}
