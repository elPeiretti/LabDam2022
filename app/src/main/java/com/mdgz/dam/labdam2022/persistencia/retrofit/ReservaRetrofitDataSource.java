package com.mdgz.dam.labdam2022.persistencia.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdgz.dam.labdam2022.model.Reserva;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.ReservaDataSource;
import com.mdgz.dam.labdam2022.persistencia.retrofit.entity.FavoritoRF;
import com.mdgz.dam.labdam2022.persistencia.retrofit.entity.ReservaRF;
import com.mdgz.dam.labdam2022.persistencia.retrofit.interfaces.FavoritoService;
import com.mdgz.dam.labdam2022.persistencia.retrofit.interfaces.ReservaService;
import com.mdgz.dam.labdam2022.persistencia.retrofit.mapper.FavoritoMapper;
import com.mdgz.dam.labdam2022.persistencia.retrofit.mapper.ReservaMapper;

import java.util.List;
import java.util.UUID;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReservaRetrofitDataSource implements ReservaDataSource {

    private ReservaService reservaService;

    public ReservaRetrofitDataSource(){
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor("EFP","CONTRASENA"))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dam-recordatorio-favoritos-api.duckdns.org")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        reservaService = retrofit.create(ReservaService.class);
    }

    @Override
    public void getAllReservas(GetAllReservasCallback callback) {
        Call<List<ReservaRF>> reqAsyn = reservaService.getAllReservas();

        reqAsyn.enqueue(new Callback<List<ReservaRF>>() {
            @Override
            public void onResponse(Call<List<ReservaRF>> call, Response<List<ReservaRF>> response) {
                Log.i("code", String.valueOf(response.code()));
                if (response.code() == 200) {
                    List<ReservaRF> data = response.body();
                    callback.onResult(ReservaMapper.fromEntities(data));
                }
                else{
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<List<ReservaRF>> call, Throwable t) {
                Log.i("data","ERRRRRRORRRR");
                callback.onError();
            }
        });
    }

    @Override
    public void saveReserva(SaveReservaCallback callback, Reserva r) {
        Call<ReservaRF> reqAsyn = reservaService.saveReserva(ReservaMapper.toEntity(r));
        reqAsyn.enqueue(new Callback<ReservaRF>() {
            @Override
            public void onResponse(Call<ReservaRF> call, Response<ReservaRF> response) {
                if(response.code() == 200) {
                    callback.onResult();
                    Log.i("Guarda", "SII");
                }
                else{
                    callback.onError();
                    Log.i("Guarda", String.valueOf(response.code()));
                    Log.i("Guarda", reqAsyn.request().toString());
                }
            }

            @Override
            public void onFailure(Call<ReservaRF> call, Throwable t) {
                callback.onError();
            }
        });
    }

    @Override
    public void removeReserva(RemoveReservaCallback callback, UUID reservaId) {
        Call<ReservaRF> reqAsyn = reservaService.removeReserva(reservaId.toString());
        reqAsyn.enqueue(new Callback<ReservaRF>() {
            @Override
            public void onResponse(Call<ReservaRF> call, Response<ReservaRF> response) {
                if(response.code()==200)
                    callback.onResult();
                else
                    callback.onError();
            }

            @Override
            public void onFailure(Call<ReservaRF> call, Throwable t) {
                callback.onError();
            }
        });
    }


}
