package com.neizatheedev.webapp.services;

import com.google.firebase.auth.*;
import com.google.firebase.cloud.*;
import com.neizatheedev.webapp.beans.*;
import org.springframework.stereotype.*;

import java.util.concurrent.ExecutionException;


@Service
public class UserService {

    public User registerUser(String email, String password, String firstName, String lastName, String gender, String country, String phoneNumber) throws FirebaseAuthException, ExecutionException, InterruptedException {
        // Create user in Firebase Auth
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);

        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);

        // Create user in Firestore with custom attributes
        User user = new User(userRecord.getUid(), email, firstName, lastName, gender, country, phoneNumber);
        FirestoreClient.getFirestore().collection("users").document(userRecord.getUid()).set(user).get();

        return user;
    }

    public User signInUser(String email, String password) throws FirebaseAuthException, ExecutionException, InterruptedException {
        // Verify user credentials using Firebase Auth
        UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email);

        // Fetch user details from Firestore
        User user = FirestoreClient.getFirestore().collection("users").document(userRecord.getUid()).get().get().toObject(User.class);

        return user;
    }
}
