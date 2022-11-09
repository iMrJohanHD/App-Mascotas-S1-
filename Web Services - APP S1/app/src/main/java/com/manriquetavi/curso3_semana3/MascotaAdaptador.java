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

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaAdaptador.MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.cvImagePet.setImageResource(mascota.getFoto());
        holder.cvFavorito.setText(String.valueOf(mascota.getFavorito()));
        holder.cvTextName.setText(mascota.getNombre());
        holder.cvImagePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_LONG).show();
            }
        });
        holder.cvImageBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste favorito a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darFavoritoMascota(mascota);
                holder.cvFavorito.setText(String.valueOf(constructorMascotas.obtenerFavoritoMascota(mascota)));
            }
        });
    }

    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView cvImagePet;
        private TextView cvFavorito;
        private TextView cvTextName;
        private ImageView cvImageBone;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            cvImageBone = (ImageView) itemView.findViewById(R.id.cvImageBone);
            cvImagePet = (ImageView) itemView.findViewById(R.id.cvImagePet);
            cvFavorito = (TextView) itemView.findViewById(R.id.cvFavorito);
            cvTextName = (TextView) itemView.findViewById(R.id.cvTextName);
        }
    }
}
