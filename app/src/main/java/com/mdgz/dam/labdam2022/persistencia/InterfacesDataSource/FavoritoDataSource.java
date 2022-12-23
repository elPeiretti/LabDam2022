package com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource;

import com.mdgz.dam.labdam2022.model.Favorito;

import java.util.List;
import java.util.UUID;

public interface FavoritoDataSource {
    interface GetAllFavoritosCallback {
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

    void getAllFavoritos(GetAllFavoritosCallback callback);
    void saveFavorito(FavoritoDataSource.SaveFavoritoCallback callback, Favorito fav);
    void removeFavorito(RemoveFavoritoCallback callback, UUID alojamientoId);
}
