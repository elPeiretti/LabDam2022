package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Ciudad;
import com.mdgz.dam.labdam2022.model.Hotel;
import com.mdgz.dam.labdam2022.persistencia.room.entities.CiudadEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HotelEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.UbicacionEntity;

import java.util.ArrayList;
import java.util.List;

public class HotelMapper {

    public static Hotel fromEntity(HotelEntity h, UbicacionEntity u, CiudadEntity c) {
        return new Hotel(
                h.getId(),
                h.getNombre(),
                h.getCategoria(),
                UbicacionMapper.fromEntity(u,c)
        );
    }

    public static HotelEntity toEntity(Hotel h) {
        return new HotelEntity(
                h.getId(),
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
