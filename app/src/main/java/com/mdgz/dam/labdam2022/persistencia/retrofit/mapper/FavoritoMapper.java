package com.mdgz.dam.labdam2022.persistencia.retrofit.mapper;

import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.retrofit.entity.FavoritoRF;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FavoritoMapper {
    public static List<Favorito> fromEntities(List<FavoritoRF> entities){
        return entities.stream().map(FavoritoMapper::fromEntity).collect(Collectors.toList());
    }

    public static Favorito fromEntity(FavoritoRF fav){
        return new Favorito(
                UUID.fromString(fav.getAlojamientoID()),
                UUID.fromString(fav.getUsuarioID())
        );
    }
}
