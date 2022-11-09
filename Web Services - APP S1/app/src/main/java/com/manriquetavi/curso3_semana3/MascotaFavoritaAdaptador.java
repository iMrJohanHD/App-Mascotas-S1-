package com.manriquetavi.curso3_semana3;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MascotaFavoritaAdaptador extends RecyclerView.Adapter<MascotaFavoritaAdaptador.MascotaFavoritaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaFavoritaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public MascotaFavoritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MascotaFavoritaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaFavoritaAdaptador.MascotaFavoritaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.cvImagePet.setImageResource(mascota.getFoto());
        holder.cvFavorito.setText(String.valueOf(mascota.getFavorito()));
        holder.cvTextName.setText(mascota.getNombre());
    }

    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaFavoritaViewHolder extends RecyclerView.ViewHolder{
        private ImageView cvImagePet;
        private TextView cvFavorito;
        private TextView cvTextName;

        public MascotaFavoritaViewHolder(View itemView) {
            super(itemView);
            cvImagePet = (ImageView) itemView.findViewById(R.id.cvImagePet);
            cvFavorito = (TextView) itemView.findViewById(R.id.cvFavorito);
            cvTextName = (TextView) itemView.findViewById(R.id.cvTextName);
        }
    }
}
