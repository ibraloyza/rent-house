package com.renthouse.controller;

import com.renthouse.model.User;
import com.renthouse.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class UserController {
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // add user
    @PostMapping("/create-user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    // get user
    @GetMapping("/get-All-Users")
    public List<User> findAllUsers(){
        return  userService.getAllUsers();
    }
    // find  user by id
    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
        return  userService.getUserById(id);
    }
    // update existing user
    @PutMapping("/update/{id}")
    public  void  updateUser(@PathVariable Long id ,@RequestBody User newUser){
        userService.updateUser(newUser,id);
    }
    // delete existing user
    @DeleteMapping("/{id}")
    public  void  deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
