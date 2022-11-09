package com.manriquetavi.curso3_semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotaFavorita extends AppCompatActivity {

    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView listaMascotasFavoritas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorita_mascota);
        listaMascotasFavoritas = findViewById(R.id.rvMascotaFavoritas);
        Toolbar action_bar = findViewById(R.id.action_bar_mf);
        setSupportActionBar(action_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<Integer> Ids = new ArrayList<>();
        Intent intent = getIntent();
        Ids = intent.getIntegerArrayListExtra("Ids");

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFavoritas.setLayoutManager(llm);
        inicializarListaMascotasFavoritas(Ids);
        inicializarAdaptadorMF();
    }

    public void inicializarAdaptadorMF(){
        MascotaFavoritaAdaptador adaptador = new MascotaFavoritaAdaptador(mascotasFavoritas, this);
        listaMascotasFavoritas.setAdapter(adaptador);
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return false;
    }

    public void inicializarListaMascotasFavoritas(ArrayList<Integer> Ids){
        mascotasFavoritas = new ArrayList<>();
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(this);
        for (int i : Ids){
            Mascota mascotaActual = new Mascota();
            mascotaActual = RecyclerViewFragmentPresenter.mascotas.get(i-1);
            mascotaActual.setFavorito(constructorMascotas.obtenerFavoritoMascota(mascotaActual));
            mascotasFavoritas.add(mascotaActual);
        }
    }
}