package com.manriquetavi.curso3_semana3;

import java.util.ArrayList;

public interface IRecyclerViewFragment {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
