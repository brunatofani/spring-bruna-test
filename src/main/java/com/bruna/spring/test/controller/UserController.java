package com.bruna.spring.test.controller;

import com.bruna.spring.test.model.User;
import com.bruna.spring.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/findUserByName")
    public ResponseEntity<User> getUserByName(@RequestBody String name) {
        User response = userService.getUserByName(name);
        return (response != null ? ResponseEntity.ok().body(response) : ResponseEntity.notFound().build());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
        User response = userService.findUserById(id);
        return (response != null ? ResponseEntity.ok().body(response) : ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/saveUser")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping(value="updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User response = userService.updateUser(id, user);
        return (response != null ? ResponseEntity.ok().body(response) : ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        boolean response = userService.deleteUser(id);
        return (response ? ResponseEntity.ok().build() : ResponseEntity.notFound().build());
    }

    @GetMapping(path ={"/findAll"})
    public List<User> findAll(){
        return userService.findAllUser();
    }
}
