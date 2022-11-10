package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Ubicacion;
import com.mdgz.dam.labdam2022.persistencia.room.entities.UbicacionEntity;

public class UbicacionMapper {

    public static Ubicacion fromEntity(UbicacionEntity u) {
        return new Ubicacion(
                u.getLat(),
                u.getLng(),
                u.getCalle(),
                u.getNumero(),
                CiudadMapper.fromEntity(u.getCiudad())
        );
    }

    public static UbicacionEntity toEntity(Ubicacion u) {
        return new UbicacionEntity(
                u.getLat(),
                u.getLng(),
                u.getCalle(),
                u.getNumero(),
                CiudadMapper.toEntity(u.getCiudad())
        );
    }
}
