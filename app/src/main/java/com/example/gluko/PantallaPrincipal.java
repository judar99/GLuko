package com.example.gluko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.gluko.adapter.AdapterAlimentos;
import com.example.gluko.struct.Alimentos;

import java.util.ArrayList;
import java.util.List;

public class PantallaPrincipal extends AppCompatActivity {

    private List<Alimentos> lst;
    private AdapterAlimentos adapter;
    private ListView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        rv = findViewById(R.id.listAlimentos);

        lst = this.getData();

        adapter = new AdapterAlimentos(PantallaPrincipal.this, R.layout.row_alimentos, lst);

        rv.setAdapter(adapter);

    }

    public List<Alimentos> getData() {
        lst = new ArrayList<>();
        lst.add(new Alimentos("Arroz con pollo", 556, 35, 1, 30));
        lst.add(new Alimentos("Arepa", 212, 30, 1, 7));
        lst.add(new Alimentos("Platano maduro", 105, 31, 100, 1));
        lst.add(new Alimentos("Manzana", 72, 10, 1, 0));
        lst.add(new Alimentos("Leche entera", 146, 11, 1, 7));
        lst.add(new Alimentos("Carne asada", 56, 0, 1, 5));

        return lst;
    }
}