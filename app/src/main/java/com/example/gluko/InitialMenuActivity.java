package com.example.gluko;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.gluko.adapter.AdapterAlimentos;
import com.example.gluko.struct.Alimentos;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

public class InitialMenuActivity extends AppCompatActivity {

    DatabaseReference reference;
    ArrayList<Alimentos> list;
    RecyclerView rv;
    SearchView searchView;
    AdapterAlimentos adapter;
    LinearLayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_menu);

        reference = FirebaseDatabase.getInstance().getReference().child("Alimentos");
        rv = findViewById(R.id.iv);
        searchView = findViewById(R.id.search);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        list = new ArrayList<>();
        adapter = new AdapterAlimentos(list);
        rv.setAdapter(adapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        Alimentos al = snapshot1.getValue(Alimentos.class);
                        list.add(al);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                buscar(s);
                return true;
            }
        });


    }

    private void buscar (String s ){
        ArrayList<Alimentos> alimentos = new ArrayList<>();
        for (Alimentos obj: list){
            if(obj.getNombre().toLowerCase().contains(s.toLowerCase())){
                alimentos.add(obj);
            }
        }
        AdapterAlimentos adapter = new AdapterAlimentos(alimentos);
        rv.setAdapter(adapter);
    }
}