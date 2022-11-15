package com.example.gluko.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gluko.R;
import com.example.gluko.struct.Alimentos;

import java.util.List;

public class AdapterAlimentos extends RecyclerView.Adapter<AdapterAlimentos.viewHolderAlimentos> {

    List<Alimentos> AlimentosList;

    public AdapterAlimentos(List<Alimentos> alimentosList) {
        AlimentosList = alimentosList;
    }

    @NonNull
    @Override
    public viewHolderAlimentos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_alimentos,parent,false);
        viewHolderAlimentos holder = new viewHolderAlimentos(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderAlimentos holder, int position) {

            Alimentos al = AlimentosList.get(position);
            holder.tvAlimento.setText(al.getNombre());
            holder.tvCalorias.setText(String.valueOf(al.getCalorias()));
            holder.tvPorcion.setText(String.valueOf(al.getPorcion()));
            holder.tvCarbohidratos.setText(String.valueOf(al.getCarbohidratos()));
            holder.tvProteina.setText(String.valueOf(al.getProteina()));



    }

    @Override
    public int getItemCount() {
        return AlimentosList.size();
    }

    public class viewHolderAlimentos extends RecyclerView.ViewHolder {

        TextView tvAlimento , tvCarbohidratos, tvPorcion, tvProteina , tvCalorias;

        public viewHolderAlimentos(@NonNull View itemView) {
            super(itemView);

            tvAlimento = itemView.findViewById(R.id.ListAlimento);
            tvCarbohidratos = itemView.findViewById(R.id.ListCarbohidratos);
            tvProteina = itemView.findViewById(R.id.ListProteina);
            tvCalorias = itemView.findViewById(R.id.ListCaloria);
            tvPorcion = itemView.findViewById(R.id.ListPorcion);


        }
    }
}
