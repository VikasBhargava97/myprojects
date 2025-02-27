package com.vikki.user.controller;

import com.vikki.user.model.User;
import com.vikki.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserManagement")
public class UserAppContoller {

    private final Logger logger = LoggerFactory.getLogger(UserAppContoller.class);
    @Autowired
    private UserService service;

    @GetMapping("/check")
    public String ping() {
        return "Check, Working...";
    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable Long id) {
        logger.info("Fetching user with id : {}", id);
        return service.getUser(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserByUserId(@PathVariable String userId) {
        try {
            User user = service.getUserByUserId(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/saveuser")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            service.saveUser(user);
            logger.info("User id : {}", user.getId());
            return new ResponseEntity<>("User saved successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("User already exist with userId : "+user.getUserId(),HttpStatus.OK);
        }
    }

}
