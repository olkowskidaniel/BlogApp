package com.example.daniel.blogapp.presenter;

import com.example.daniel.blogapp.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    public Database(){
        database = FirebaseDatabase.getInstance();
    }

    public void saveUserToDataBase(User user) {
        databaseReference = database.getReference("Users/RP6ICq1sfU1At6CAPC5u");
        databaseReference.setValue(user);
    }
}
