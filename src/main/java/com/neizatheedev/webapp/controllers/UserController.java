package com.neizatheedev.webapp.controllers;

import com.google.firebase.auth.FirebaseAuthException;
import com.neizatheedev.webapp.beans.User;
import com.neizatheedev.webapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationRequest request) {
        try {
            User user = userService.registerUser(request.getEmail(), request.getPassword(), request.getDisplayName());
            return ResponseEntity.ok(user);
        } catch (FirebaseAuthException | ExecutionException | InterruptedException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<User> signInUser(@RequestBody UserSignInRequest request) {
        try {
            User user = userService.signInUser(request.getEmail(), request.getPassword());
            return ResponseEntity.ok(user);
        } catch (FirebaseAuthException | ExecutionException | InterruptedException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    static class UserRegistrationRequest {
        private String email;
        private String password;
        private String displayName;

        // Getters and Setters
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }

    static class UserSignInRequest {
        private String email;
        private String password;

        // Getters and Setters
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}


