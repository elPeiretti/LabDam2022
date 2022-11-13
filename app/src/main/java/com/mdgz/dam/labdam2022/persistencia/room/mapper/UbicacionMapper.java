package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Ubicacion;
import com.mdgz.dam.labdam2022.persistencia.room.entities.UbicacionEntity;

import java.util.ArrayList;
import java.util.List;

public class UbicacionMapper {

    public static Ubicacion fromEntity(UbicacionEntity u) {
        return new Ubicacion(
                u.getId(),
                u.getLat(),
                u.getLng(),
                u.getCalle(),
                u.getNumero(),
                CiudadMapper.fromEntity(u.getCiudad())
        );
    }

    public static UbicacionEntity toEntity(Ubicacion u) {
        return new UbicacionEntity(
                u.getId(),
                u.getLat(),
                u.getLng(),
                u.getCalle(),
                u.getNumero(),
                CiudadMapper.toEntity(u.getCiudad())
        );
    }
    public static List<UbicacionEntity> toEntities (List<Ubicacion> ubicaciones){
        List<UbicacionEntity> ubic = new ArrayList<UbicacionEntity>();
        for(Ubicacion u: ubicaciones){
            ubic.add(UbicacionMapper.toEntity(u));
        }
        return ubic;
    }
}
