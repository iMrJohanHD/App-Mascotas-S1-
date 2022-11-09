package com.manriquetavi.curso3_semana3;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter{
    private IPerfilFragment iPerfilFragment;
    private Context context;
    private BioItem bioItem;
    private ArrayList<ProfileItem> profileItems;

    public PerfilFragmentPresenter(IPerfilFragment iPerfilFragment, Context context){
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        obtenerInformacionUsuario();
        obtenerMediosRecientes();

    }
    @Override
    public void obtenerInformacionUsuario() {
        RestApiAdapter restApiAdapter =  new RestApiAdapter();
        Gson gsonBio = restApiAdapter.construyeGsonDeserializadorBio();
        EndpointsAPI endpointsAPI = restApiAdapter.establecerConexionRestApiInstagram(gsonBio);
        Call<BioResponse> bioResponseCall = endpointsAPI.getBioInfo();
        bioResponseCall.enqueue(new Callback<BioResponse>() {
            @Override
            public void onResponse(Call<BioResponse> call, Response<BioResponse> response) {
                BioResponse bioResponse = response.body();
                bioItem = bioResponse.getBioItem();
                iPerfilFragment.showProfile(bioItem);
            }

            @Override
            public void onFailure(Call<BioResponse> call, Throwable t) {
                Toast.makeText(context, "Falló la conexión con servidor", Toast.LENGTH_LONG).show();
                Log.e("Connection failed", t.toString());

            }
        });

    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediosRecientes = restApiAdapter.buildGsonDeserializeMediaRecent();
        EndpointsAPI endpointsAPI = restApiAdapter.establecerConexionRestApiInstagram(gsonMediosRecientes);
        Call<MascotaResponse> mascotaResponseCall = endpointsAPI.getRecentMedia();
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                if (!response.isSuccessful()) {
                    Log.e("Error", "Error " + response.code());
                    Toast.makeText(context, "Error response is not successful", Toast.LENGTH_SHORT).show();

                } else {
                    MascotaResponse mascotaResponse = response.body();
                    profileItems = mascotaResponse.getProfileItems();
                    mostrarMediosRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                    Toast.makeText(context, "Falló la conexión con servidor", Toast.LENGTH_LONG).show();
                    Log.e("Connection failed", t.toString());
                }
        });
    }

    @Override
    public void mostrarMediosRecyclerView() {
        iPerfilFragment.inicializarAdaptador(iPerfilFragment.createAdaptador(profileItems));
        iPerfilFragment.generateGridLayout();
    }
}
