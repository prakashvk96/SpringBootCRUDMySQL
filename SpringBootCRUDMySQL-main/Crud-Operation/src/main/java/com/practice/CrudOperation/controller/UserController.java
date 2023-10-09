package com.practice.CrudOperation.controller;


import com.practice.CrudOperation.exceptions.UserNotFoundException;
import com.practice.CrudOperation.model.Address;
import com.practice.CrudOperation.model.User;
import com.practice.CrudOperation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList =  userService.getAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        User user =  userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/postUser")
    public ResponseEntity<User> postUser(@RequestBody User user){
        long startTime = System.currentTimeMillis();
        Address addressDto = user.getAddress();
        Address add = new Address();
        add.setCity(addressDto.getCity());
        add.setState(addressDto.getState());
        add.setFlatNo(addressDto.getFlatNo());
        add.setLandmark(addressDto.getLandmark());
        user.setAddress(add);
        User savedUser = userService.createUser(user);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        log.error(
                String.format("Time taken by post user: %d", elapsedTime)
        );
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }

    @PutMapping("/putUser/{id}")
    public ResponseEntity<User> upadateUserById(@PathVariable Long id, @RequestBody User user) throws UserNotFoundException {
        User exitingUser = userService.getUserById(id);
        user.setUserId(exitingUser.getUserId());
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @PatchMapping("/patchUser/{id}")
    public ResponseEntity<User> patchUpadateUserById(@PathVariable Long id, @RequestBody Map<Object,Object> user) throws UserNotFoundException {
        User updatedUser = userService.updateUserById(id, user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted Successfully",HttpStatus.OK);
    }




}
