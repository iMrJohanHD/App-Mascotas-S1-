package com.manriquetavi.curso3_semana3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaPerfilViewHolder>{
    ArrayList<ProfileItem> profileItems;
    Activity activity;


    public MascotaPerfilAdaptador(ArrayList<ProfileItem> profileItems, Activity activity){
        this.profileItems = profileItems;
        this.activity = activity;
    }

    public MascotaPerfilAdaptador.MascotaPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_small, parent, false);
        return new MascotaPerfilAdaptador.MascotaPerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaPerfilAdaptador.MascotaPerfilViewHolder holder, int position) {
        final ProfileItem profileItem = profileItems.get(position);
        holder.cvsFavorito.setText(String.valueOf(profileItem.getLikes()));
        holder.cvsImageBoneYellow.setImageResource(R.drawable.bone_yellow);
        Picasso.with(activity).
                load(profileItem.getUrlPetPic()).
                placeholder(R.drawable.cat).
                into(holder.cvsImagePet);
    }

    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return profileItems.size();
    }

    public static class MascotaPerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView cvsImagePet;
        private TextView cvsFavorito;
        private ImageView cvsImageBoneYellow;

        public MascotaPerfilViewHolder(View itemView) {
            super(itemView);
            cvsImagePet = (ImageView) itemView.findViewById(R.id.cvsImagePet);
            cvsFavorito = (TextView) itemView.findViewById(R.id.cvsFavorito);
            cvsImageBoneYellow = (ImageView) itemView.findViewById(R.id.cvsImageBoneYellow);
        }
    }
}
