package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Ciudad;
import com.mdgz.dam.labdam2022.persistencia.room.entities.CiudadEntity;

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
}
