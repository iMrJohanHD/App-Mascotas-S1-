package com.manriquetavi.curso3_semana3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsAPI {
    @GET(ConstantesRestApi.URL_USER_BIO)
    Call<BioResponse> getBioInfo();

    @GET(ConstantesRestApi.URL_USER_MEDIA)
    Call<MascotaResponse> getRecentMedia();
}
