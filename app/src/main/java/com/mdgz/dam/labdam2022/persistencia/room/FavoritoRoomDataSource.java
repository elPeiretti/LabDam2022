package com.mdgz.dam.labdam2022.persistencia.room;

import android.content.Context;

import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.persistencia.room.dao.FavoritoDAO;
import com.mdgz.dam.labdam2022.persistencia.room.entities.FavoritoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.FavoritoMapper;

import java.util.ArrayList;
import java.util.List;

public class FavoritoRoomDataSource implements FavoritoDataSource {

    private final FavoritoDAO favoritoDAO;

    public FavoritoRoomDataSource(Context ctx) {
        MyDatabase bdd = MyDatabase.getInstance(ctx);
        favoritoDAO = bdd.favoritoDAO();
    }


    @Override
    public void getAllFavoritos(GetAllFavortosCallback callback) {
        List<FavoritoEntity> favs = favoritoDAO.loadAllFavoritos();
        callback.onResult(FavoritoMapper.fromEntities(favs));
    }

    @Override
    public void saveFavorito(SaveFavoritoCallback callback, Favorito fav) {
        favoritoDAO.insertFavorito(FavoritoMapper.toEntity(fav));
        callback.onResult();
    }

    @Override
    public void removeFavorito(RemoveFavoritoCallback callback, Favorito fav) {
        favoritoDAO.deleteFavorito(FavoritoMapper.toEntity(fav));
        callback.onResult();
    }
}
