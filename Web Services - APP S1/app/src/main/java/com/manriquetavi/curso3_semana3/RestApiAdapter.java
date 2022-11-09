package com.manriquetavi.curso3_semana3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public EndpointsAPI establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        return retrofit.create(EndpointsAPI.class);
    }

    public Gson construyeGsonDeserializadorBio(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BioResponse.class, new BioDeserializador());
        return gsonBuilder.create();
    }

    public Gson buildGsonDeserializeMediaRecent() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }
}
