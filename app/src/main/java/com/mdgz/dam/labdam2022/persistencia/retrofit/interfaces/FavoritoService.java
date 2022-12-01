package com.mdgz.dam.labdam2022.persistencia.retrofit.interfaces;

import com.mdgz.dam.labdam2022.persistencia.retrofit.entity.FavoritoRF;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FavoritoService {

    @GET("favorito")
    Call<List<FavoritoRF>> getAllFavoritos();

    @POST("favorito")
    Call<FavoritoRF> saveFavorito(@Body FavoritoRF fav);

}
