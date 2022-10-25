 package com.example.gluko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

 public class RegisterActivity<mAuth> extends AppCompatActivity {

     private FirebaseAuth mAuth;
     private EditText email;
     private EditText password;
     private EditText repeatPassword;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_register);

         mAuth = FirebaseAuth.getInstance();
         email = findViewById(R.id.correo);
         password = findViewById(R.id.Password);
         repeatPassword= findViewById(R.id.RepeatPassword);
     }

     @Override
     public void onStart() {
         super.onStart();
         // Check if user is signed in (non-null) and update UI accordingly.
         FirebaseUser currentUser = mAuth.getCurrentUser();
         //updateUI(currentUser);
     }

     public void registerUser(View view){

         if(password.getText().toString().equals(repeatPassword.getText().toString())){

             mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                     .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             if (task.isSuccessful()) {
                                 // Sign in success, update UI with the signed-in user's information
                                 Toast.makeText(getApplicationContext(),"Usuario Creado", Toast.LENGTH_SHORT).show();
                                 FirebaseUser user = mAuth.getCurrentUser();
                                 Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                 startActivity(i);

                             } else {
                                 // If sign in fails, display a message to the user.

                                 Toast.makeText(getApplicationContext(), "Authentication failed.",Toast.LENGTH_SHORT).show();

                             }
                         }
                     });
         }
         else{
             Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
         }

     }
 }