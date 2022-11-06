package com.mdgz.dam.labdam2022.persistencia.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.mdgz.dam.labdam2022.model.Favorito;
import java.util.List;

@Dao
public interface FavoritoDAO {

    @Query("SELECT * FROM favorito")
    List<Favorito> loadAllFavoritos();

    @Insert
    void insertFavorito(Favorito fav);

}
