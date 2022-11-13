package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Hotel;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HotelEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.UbicacionEntity;

import java.util.ArrayList;
import java.util.List;

public class HotelMapper {

    public static Hotel fromEntity(HotelEntity h, UbicacionEntity u) {
        return new Hotel(
                h.getId(),
                h.getNombre(),
                h.getCategoria(),
                UbicacionMapper.fromEntity(u)
        );
    }

    public static HotelEntity toEntity(Hotel h) {
        return new HotelEntity(
                h.getNombre(),
                h.getCategoria(),
                UbicacionMapper.toEntity(h.getUbicacion()).getId()
        );
    }
    public static List<HotelEntity> toEntities(List<Hotel> hoteles){
        List<HotelEntity> he = new ArrayList<HotelEntity>();
        for(Hotel h : hoteles){
            he.add(HotelMapper.toEntity(h));
        }
        return he;
    }
}
