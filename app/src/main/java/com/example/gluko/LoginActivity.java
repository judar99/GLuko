package com.example.gluko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.correo);
        password = findViewById(R.id.passwordd);
    }

    public void login (View view){
        if(validateFrom()) {
            mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Autenticacion Exitosa.", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(),InitialMenuActivity.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(getApplicationContext(), "Fallo la autenticación del usuario.", Toast.LENGTH_SHORT).show();
                                email.setText("");
                                password.setText("");
                            }
                        }

                    });
        }
    }

    private boolean validateFrom() {
        boolean valid = true;
        String correo = email.getText().toString();
        if(TextUtils.isEmpty(correo)) {
            email.setError("Campo requerido");
            valid = false;
        } else {
            email.setError(null);
        }

        String pass = password.getText().toString();
        if(TextUtils.isEmpty(pass)) {
            password.setError("Campo requerido");
            valid = false;
        } else {
            password.setError(null);
        }
        return valid;

    }
}