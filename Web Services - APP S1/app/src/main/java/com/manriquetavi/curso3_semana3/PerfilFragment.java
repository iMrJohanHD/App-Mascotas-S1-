package com.manriquetavi.curso3_semana3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PerfilFragment extends Fragment implements IPerfilFragment{
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvsMascotas;
    private IPerfilFragmentPresenter iPerfilFragmentPresenter;
    private ImageView imgPerfil;
    private TextView tvName;
    private TextView tvBiography;
    private TextView tvFollowers;
    private TextView tvFollows;
    private TextView tvMediaCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        iPerfilFragmentPresenter = new PerfilFragmentPresenter(this,getContext());
        rvsMascotas = (RecyclerView) v.findViewById(R.id.rvsMascotas);
        imgPerfil = v.findViewById(R.id.imgPerfil);
        tvName = v.findViewById(R.id.tvName);
        tvBiography = v.findViewById(R.id.tvBiography);
        tvFollowers = v.findViewById(R.id.tvFollowers);
        tvFollows = v.findViewById(R.id.tvFollows);
        tvMediaCount = v.findViewById(R.id.tvMediaCount);
        return v;
    }


    @Override
    public void generateGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rvsMascotas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public MascotaPerfilAdaptador createAdaptador(ArrayList<ProfileItem> perfilItems) {
        MascotaPerfilAdaptador mascotaPerfilAdaptador = new MascotaPerfilAdaptador(perfilItems, getActivity());
        return mascotaPerfilAdaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaPerfilAdaptador perfilAdaptador) {
        rvsMascotas.setAdapter(perfilAdaptador);
    }

    @Override
    public void showProfile(BioItem bioItem) {
        Picasso.with(getContext()).load(bioItem.getProfile_picture_url()).placeholder(R.drawable.turtle)
                .into(imgPerfil);
        tvName.setText("Name: " + bioItem.getName());
        tvBiography.setText("Biografia: " + bioItem.getBiography());
        tvFollowers.setText("Seguidores: " + String.valueOf(bioItem.getFollowers_count()));
        tvFollows.setText("Seguidos: " + String.valueOf(bioItem.getFollows_count()));
        tvMediaCount.setText("Media count: " + String.valueOf(bioItem.getMedia_count()));
    }
}
