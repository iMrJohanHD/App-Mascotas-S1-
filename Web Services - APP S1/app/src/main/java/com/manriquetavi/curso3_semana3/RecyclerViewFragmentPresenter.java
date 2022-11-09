package com.manriquetavi.curso3_semana3;

import android.content.Context;

import androidx.collection.CircularArray;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    static ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.generarLinearLayoutVertical();
    }
}
