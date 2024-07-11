package com.neizatheedev.webapp.services;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import com.neizatheedev.webapp.beans.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    public User registerUser(String email, String password, String displayName) throws FirebaseAuthException, ExecutionException, InterruptedException {
        // Create user in Firebase Auth
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password)
                .setDisplayName(displayName);

        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);

        // Create user in Firestore
        User user = new User(userRecord.getUid(), email, displayName);
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
