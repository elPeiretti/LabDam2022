package com.mdgz.dam.labdam2022.persistencia.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.room.entities.FavoritoEntity;

import java.util.List;

@Dao
public interface FavoritoDAO {

    @Query("SELECT * FROM favoritoentity")
    List<FavoritoEntity> loadAllFavoritos();

    @Insert
    void insertFavorito(FavoritoEntity fav);

    @Delete
    void deleteFavorito(FavoritoEntity fav);

}
