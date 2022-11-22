package com.example.gluko.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gluko.R;
import com.example.gluko.struct.Alimentos;

import java.util.List;

public class AdapterAlimentos extends ArrayAdapter<Alimentos> {

    private List<Alimentos> alimentosList;
    private Context context;
    private int resourceLayout;

    public AdapterAlimentos(@NonNull Context context, int resource, List<Alimentos> objects) {
        super(context, resource, objects);
        this.alimentosList = objects;
        this.context = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_alimentos, null);
        }

        Alimentos alimento = alimentosList.get(position);

        TextView alimentoN = view.findViewById(R.id.ListAlimento);
        alimentoN.setText(alimento.getNombre());

        TextView carbo = view.findViewById(R.id.ListCarbohidratos);
        carbo.setText(String.valueOf(alimento.getCarbohidratos()));

        TextView proteina = view.findViewById(R.id.ListProteina);
        proteina.setText(String.valueOf(alimento.getProteina()));

        TextView caloria = view.findViewById(R.id.ListCaloria);
        caloria.setText(String.valueOf(alimento.getCalorias()));

        TextView porcion = view.findViewById(R.id.ListPorcion);
        porcion.setText(String.valueOf(alimento.getPorcion()));

        return  view;
    }
}
