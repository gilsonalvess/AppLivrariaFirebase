package com.dwm.ufg.applivrariafirebase;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseUtils {

    static FirebaseDatabase firebaseDatabase;
    static DatabaseReference databaseReference;

    static DatabaseReference inicializeFirebase(Context context) {
        FirebaseApp.initializeApp(context);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        return databaseReference;
    }

}
