package com.mdgz.dam.labdam2022.persistencia.retrofit.interfaces;

import com.mdgz.dam.labdam2022.persistencia.retrofit.entity.ReservaRF;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ReservaService {


    @GET("reserva")
    Call<List<ReservaRF>> getAllReservas();

    @POST("reserva")
    Call<ReservaRF> saveReserva(@Body ReservaRF res);

    @DELETE("reserva")
    Call<ReservaRF> removeReserva(@Query("id") String alojamientoId);
}
