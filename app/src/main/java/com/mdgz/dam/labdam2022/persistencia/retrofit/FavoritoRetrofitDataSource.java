package com.mdgz.dam.labdam2022.persistencia.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.retrofit.entity.FavoritoRF;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.persistencia.retrofit.interfaces.FavoritoService;
import com.mdgz.dam.labdam2022.persistencia.retrofit.mapper.FavoritoMapper;

import java.io.IOException;
import java.util.List;

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
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        favoritoService = retrofit.create(FavoritoService.class);
    }


    @Override
    public void getAllFavoritos(GetAllFavoritosCallback callback) {
        Call<List<FavoritoRF>> reqAsyn = favoritoService.getAllFavoritos();

        reqAsyn.enqueue(new Callback<List<FavoritoRF>>() {
            @Override
            public void onResponse(Call<List<FavoritoRF>> call, Response<List<FavoritoRF>> response) {
                if(response.code() == 200) {
                    List<FavoritoRF> data = response.body();
                    Log.i("data",String.valueOf(data.size()));
                    callback.onResult(FavoritoMapper.fromEntities(data));
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

    }

    @Override
    public void removeFavorito(RemoveFavoritoCallback callback, Favorito fav) {

    }
}
