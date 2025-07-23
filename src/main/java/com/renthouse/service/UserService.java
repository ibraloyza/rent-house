package com.renthouse.service;

import com.renthouse.model.User;
import com.renthouse.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // add  a user
    public void  addUser(User user){
        userRepo.save(user);
    }

    // get all users
    public List<User> getAllUsers(){
        return  userRepo.findAll();
    }

    //get  user by id
    public  User getUserById(Long id){
        return  userRepo.findById(id).orElse(null);
    }

    // update existing user
    public  void  updateUser(User newUser, Long id){
        newUser.setId(id);
        userRepo.save(newUser);
    }

    // delete existing user
    public  void  deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
