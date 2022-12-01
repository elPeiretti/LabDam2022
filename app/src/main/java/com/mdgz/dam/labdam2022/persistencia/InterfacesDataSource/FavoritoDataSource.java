package com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource;

import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Favorito;

import java.util.List;

public interface FavoritoDataSource {
    interface GetAllFavortosCallback {
        void onError();
        void onResult(List<Favorito> favs);
    }
    interface SaveFavoritoCallback {
        void onError();
        void onResult();
    }
    interface RemoveFavoritoCallback{
        void onError();
        void onResult();
    }

    void getAllFavoritos(FavoritoDataSource.GetAllFavortosCallback callback);
    void saveFavorito(FavoritoDataSource.SaveFavoritoCallback callback, Favorito fav);
    void removeFavorito(FavoritoDataSource.RemoveFavoritoCallback callback, Favorito fav);
}
