package com.mdgz.dam.labdam2022.persistencia.room;

import android.content.Context;

import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.persistencia.room.dao.FavoritoDAO;

import java.util.ArrayList;
import java.util.List;

public class FavoritoRoomDataSource implements FavoritoDataSource {

    private FavoritoDAO favoritoDAO;

    public FavoritoRoomDataSource(Context ctx) {
        MyDatabase bdd = MyDatabase.getInstance(ctx);
        favoritoDAO = bdd.favoritoDAO();
    }


    @Override
    public void getAllFavoritos(GetAllFavortosCallback callback) {
        List<Favorito> favs = new ArrayList<Favorito>();
        favs.addAll(favoritoDAO.loadAllFavoritos());
        callback.onResult(favs);
    }

    @Override
    public void saveFavorito(SaveFavoritoCallback callback, Favorito fav) {
        favoritoDAO.insertFavorito(fav);
        callback.onResult();
    }
}
