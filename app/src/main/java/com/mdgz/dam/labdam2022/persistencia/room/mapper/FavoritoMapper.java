package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.room.entities.FavoritoEntity;

import java.util.List;
import java.util.stream.Collectors;

public class FavoritoMapper {

    public static List<Favorito> fromEntities(List<FavoritoEntity> favs) {
        return favs.stream().map(FavoritoMapper::fromEntity).collect(Collectors.toList());
    }

    public static Favorito fromEntity(FavoritoEntity f){
        return new Favorito(
                f.getId(),
                f.getAlojamientoID(),
                f.getUsuarioID()
        );
    }

    public static FavoritoEntity toEntity(Favorito f) {
        return new FavoritoEntity(
                f.getId(),
                f.getAlojamientoID(),
                f.getUsuarioID()
        );
    }
}
