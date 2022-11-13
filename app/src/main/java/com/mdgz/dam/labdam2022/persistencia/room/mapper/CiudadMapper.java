package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Ciudad;
import com.mdgz.dam.labdam2022.persistencia.room.entities.CiudadEntity;

import java.util.ArrayList;
import java.util.List;

public class CiudadMapper {

    public static Ciudad fromEntity(CiudadEntity c) {
        return new Ciudad(
                c.getNombre(),
                c.getAbreviatura()
        );
    }

    public static CiudadEntity toEntity(Ciudad c) {
        return new CiudadEntity(
                c.getNombre(),
                c.getAbreviatura()
        );
    }
    public static List<CiudadEntity> toEntities(List<Ciudad> ciudades){
        List<CiudadEntity> ciud = new ArrayList<CiudadEntity>();
        for(Ciudad c : ciudades){
            ciud.add(CiudadMapper.toEntity(c));
        }
        return ciud;
    }
}
