package com.mdgz.dam.labdam2022.persistencia.retrofit.interfaces;

import com.mdgz.dam.labdam2022.persistencia.retrofit.entity.FavoritoRF;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FavoritoService {

    @GET("reserva/")
    Call<List<FavoritoRF>> getAllFavoritos();

}
