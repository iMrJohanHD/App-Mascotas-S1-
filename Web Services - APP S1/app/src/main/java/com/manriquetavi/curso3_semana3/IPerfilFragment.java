package com.manriquetavi.curso3_semana3;

import java.util.ArrayList;

public interface IPerfilFragment {
    public void generateGridLayout();
    public MascotaPerfilAdaptador createAdaptador(ArrayList<ProfileItem> perfilItems);
    public void inicializarAdaptador(MascotaPerfilAdaptador mascotaPerfilAdaptador);
    public void showProfile(BioItem bioItem);
}
