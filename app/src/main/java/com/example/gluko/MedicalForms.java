package com.example.gluko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MedicalForms extends AppCompatActivity {


    private Spinner basal;
    private Spinner speed;
    private EditText ratio;
    private EditText time;
    private EditText sensitivity;
    private EditText range;
    private EditText afterEate;
    private EditText IMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_forms);



        basal = findViewById(R.id.basal);
        speed = findViewById(R.id.speedAction);
        ratio = findViewById(R.id.ratio);
        time = findViewById(R.id.timeInsulina);
        sensitivity = findViewById(R.id.sensitivity);
        range = findViewById(R.id.range);
        afterEate = findViewById(R.id.AfterEat);
        IMC = findViewById(R.id.ICM);


        String[] opcionesSpeed = {"Apidra®" , "Fiasp®","Gensulin®","Humalog®","Humulin®","Insuman®","Liprolog®","Novolin®","Novolog®","Novorapid®","Regular"};
        ArrayAdapter<String> arraySpeed = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opcionesSpeed);
        speed.setAdapter(arraySpeed);

        String[] opcionesBasal = {"Novolog® 50/50" , "novolog® 70/30","NovoMix® 30","NovoMix® 50","NovoMix® 70","NovoRapid® 70/30","NPH","Prothophane®","Ryzodeg®","Toujeo®","Tresiba®","Basaglar®"};
        ArrayAdapter<String> arrayBasal = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opcionesSpeed);
        basal.setAdapter(arraySpeed);
    }

    public void registeForms (View view){
        Toast.makeText(this, "implementar", Toast.LENGTH_SHORT).show();
    }
}
