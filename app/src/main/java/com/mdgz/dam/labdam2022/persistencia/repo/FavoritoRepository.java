package com.mdgz.dam.labdam2022.persistencia.repo;

import android.content.Context;

import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.persistencia.retrofit.FavoritoRetrofitDataSource;

import java.util.UUID;

public class FavoritoRepository implements FavoritoDataSource {

    private FavoritoDataSource favoritoDataSource;

    private FavoritoRepository(){}

    public FavoritoRepository(FavoritoDataSource favoritoDataSource) {
        this.favoritoDataSource = favoritoDataSource;
    }

    public static FavoritoDataSource createInstance() {
        return new FavoritoRepository(new FavoritoRetrofitDataSource());
    }

    @Override
    public void getAllFavoritos(GetAllFavoritosCallback callback) {
        favoritoDataSource.getAllFavoritos(callback);
    }

    @Override
    public void saveFavorito(SaveFavoritoCallback callback, Favorito fav) {
        favoritoDataSource.saveFavorito(callback,fav);
    }

    @Override
    public void removeFavorito(RemoveFavoritoCallback callback, UUID alojamientoId) {
        favoritoDataSource.removeFavorito(callback, alojamientoId);
    }
}
