package com.Api.apiSpring.controllers;

import com.Api.apiSpring.models.User;
import com.Api.apiSpring.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/patients")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity createUser(@RequestBody User user){
        return new ResponseEntity(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable() Long id) {
        return new ResponseEntity(userService.getUser(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity(userService.updateUser(id, user), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        return new ResponseEntity(userService.deleteUser(id), HttpStatus.OK);
    }
}
