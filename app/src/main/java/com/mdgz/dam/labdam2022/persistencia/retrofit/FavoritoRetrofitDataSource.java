package com.mdgz.dam.labdam2022.persistencia.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.retrofit.entity.FavoritoRF;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.persistencia.retrofit.interfaces.FavoritoService;
import com.mdgz.dam.labdam2022.persistencia.retrofit.mapper.FavoritoMapper;

import java.util.List;
import java.util.UUID;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavoritoRetrofitDataSource implements FavoritoDataSource{

    private FavoritoService favoritoService;

    public FavoritoRetrofitDataSource(){
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor("EFP","CONTRASENA"))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dam-recordatorio-favoritos-api.duckdns.org")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        favoritoService = retrofit.create(FavoritoService.class);
    }


    @Override
    public void getAllFavoritos(GetAllFavoritosCallback callback) {
        Call<List<FavoritoRF>> reqAsyn = favoritoService.getAllFavoritos();

        reqAsyn.enqueue(new Callback<List<FavoritoRF>>() {
            @Override
            public void onResponse(Call<List<FavoritoRF>> call, Response<List<FavoritoRF>> response) {
                if (response.code() == 200) {
                    List<FavoritoRF> data = response.body();
                    callback.onResult(FavoritoMapper.fromEntities(data));
                }
                else{
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<List<FavoritoRF>> call, Throwable t) {
                Log.i("data","ERRRRRRORRRR");
                callback.onError();
            }
        });

    }

    @Override
    public void saveFavorito(SaveFavoritoCallback callback, Favorito fav) {
        Call<FavoritoRF> reqAsyn = favoritoService.saveFavorito(FavoritoMapper.toEntity(fav));
        reqAsyn.enqueue(new Callback<FavoritoRF>() {
           @Override
           public void onResponse(Call<FavoritoRF> call, Response<FavoritoRF> response) {
               if(response.code() == 200)
                   callback.onResult();
               else{
                   callback.onError();
               }
           }

           @Override
           public void onFailure(Call<FavoritoRF> call, Throwable t) {
                callback.onError();
           }
        });
    }

    @Override
    public void removeFavorito(RemoveFavoritoCallback callback, UUID alojamientoId) {
        Call<FavoritoRF> reqAsyn = favoritoService.removeFavorito(alojamientoId.toString());
        reqAsyn.enqueue(new Callback<FavoritoRF>() {
            @Override
            public void onResponse(Call<FavoritoRF> call, Response<FavoritoRF> response) {
                if(response.code()==200)
                    callback.onResult();
                else
                    callback.onError();
            }

            @Override
            public void onFailure(Call<FavoritoRF> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
