package com.neizatheedev.webapp.controllers;

import com.google.firebase.auth.*;
import com.neizatheedev.webapp.beans.*;
import com.neizatheedev.webapp.services.*;
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
            User user = userService.registerUser(
                    request.getEmail(), request.getPassword(), request.getFirstName(), request.getLastName(),
                    request.getGender(), request.getCountry(), request.getPhoneNumber());
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
        private String email, password, firstName, lastName, gender, country, phoneNumber;

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

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

    static class UserSignInRequest {
        private String email, password;

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


