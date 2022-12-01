package com.mdgz.dam.labdam2022.persistencia.repo;

import android.content.Context;

import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.persistencia.room.FavoritoRoomDataSource;

public class FavoritoRepository implements FavoritoDataSource {

    private FavoritoDataSource favoritoDataSource;

    private FavoritoRepository(){}

    public FavoritoRepository(FavoritoDataSource favoritoDataSource) {
        this.favoritoDataSource = favoritoDataSource;
    }

    public static FavoritoDataSource createInstance(Context ctx) {
        return new FavoritoRepository(new FavoritoRoomDataSource(ctx));
    }

    @Override
    public void getAllFavoritos(GetAllFavortosCallback callback) {
        favoritoDataSource.getAllFavoritos(callback);
    }

    @Override
    public void saveFavorito(SaveFavoritoCallback callback, Favorito fav) {
        favoritoDataSource.saveFavorito(callback,fav);
    }

    @Override
    public void removeFavorito(RemoveFavoritoCallback callback, Favorito fav) {
        favoritoDataSource.removeFavorito(callback,fav);
    }
}
