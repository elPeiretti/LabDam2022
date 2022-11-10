package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Hotel;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HotelEntity;

public class HotelMapper {

    public static Hotel fromEntity(HotelEntity h) {
        return new Hotel(
                h.getId(),
                h.getNombre(),
                h.getCategoria(),
                UbicacionMapper.fromEntity(h.getUbicacion())
        );
    }

    public static HotelEntity toEntity(Hotel h) {
        return new HotelEntity(
                h.getId(),
                h.getNombre(),
                h.getCategoria(),
                UbicacionMapper.toEntity(h.getUbicacion())
        );
    }
}
