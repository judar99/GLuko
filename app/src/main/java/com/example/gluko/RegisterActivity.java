 package com.example.gluko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

 public class RegisterActivity<mAuth> extends AppCompatActivity {

     private FirebaseAuth mAuth;

     private EditText nombre;
     private EditText lastName;
     private EditText edad;
     private RadioButton male;
     private RadioButton female;
     private EditText height;
     private EditText weight;
     private RadioButton top;
     private RadioButton mid;
     private RadioButton bot;
     private EditText email;
     private EditText password;
     private EditText repeatPassword;
     // Write a message to the database

     DatabaseReference myRef;




     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_register);

         myRef = FirebaseDatabase.getInstance().getReference();
         mAuth = FirebaseAuth.getInstance();
         nombre=findViewById(R.id.name);
         email = findViewById(R.id.correo);
         edad = findViewById(R.id.age);
         male = (RadioButton) findViewById(R.id.male);
         female = (RadioButton) findViewById(R.id.female);
         height = findViewById(R.id.height);
         weight = findViewById(R.id.weight);
         top = (RadioButton) findViewById(R.id.top);
         mid = (RadioButton) findViewById(R.id.mid);
         bot = (RadioButton) findViewById(R.id.bot);




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
                                 Toast.makeText(getApplicationContext(),"Registro Exitoso", Toast.LENGTH_SHORT).show();
                                 FirebaseUser user = mAuth.getCurrentUser();



                                 Map<String , Object> dataUser = new HashMap<>();
                                 dataUser.put("nombre", nombre.getText().toString());
                                 dataUser.put("correo", email.getText().toString());
                                 dataUser.put("contraseña", password.getText().toString());
                                 dataUser.put("edad" , edad.getText().toString());

                                 if (male.isChecked()==true){
                                     dataUser.put("sexo" , "Masculino");
                                 }
                                 else{dataUser.put("sexo" , "Femenino");}

                                 dataUser.put("Peso" , weight.getText().toString());
                                 dataUser.put("altura" , height.getText().toString());

                                if(top.isChecked()==true){ dataUser.put("actividad" , "Alta"); }
                                else if (mid.isChecked()==true ){dataUser.put("activdad" , "Media");}
                                else{dataUser.put("actividad", "baja");}

                                 myRef.child("Usuarios").push().setValue(dataUser);

                                 Intent i = new Intent(getApplicationContext(),MedicalForms.class);
                                 //i.putExtra("usuario", user);
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