package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.persistencia.room.entities.AlojamientoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HabitacionEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HotelEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.UbicacionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HabitacionMapper {

    public static Habitacion fromEntity(HabitacionEntity h, AlojamientoEntity a, HotelEntity hotel, UbicacionEntity u) {

        return new Habitacion(
                h.getId_habitacion(),
                a.getTitulo(),
                a.getDescripcion(),
                a.getCapacidad(),
                a.getPrecioBase(),
                h.getCamasIndividuales(),
                h.getCamasMatrimoniales(),
                h.getTieneEstacionamiento(),
                HotelMapper.fromEntity(hotel, u),
                a.getFoto()
        );
    }

    public static List<Habitacion> fromEntities(List<HabitacionEntity> hab){
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();
        for(HabitacionEntity h: hab){
            habitaciones.add(HabitacionMapper.fromEntity(h, h.getAlojamientoEntity(), h.getHotelEntity(), h.getHotelEntity().getUbicacionEntity()));
        }
        return habitaciones;
    }

    public static List<HabitacionEntity> toEntities(List<Habitacion> habitaciones) {
        return habitaciones.stream().map(HabitacionMapper::toEntity).collect(Collectors.toList());
    }

    public static HabitacionEntity toEntity(Habitacion h){
        return new HabitacionEntity(
                h.getId_habitacion(),
                h.getTitulo(),
                h.getDescripcion(),
                h.getCapacidad(),
                h.getPrecioBase(),
                h.getCamasIndividuales(),
                h.getCamasMatrimoniales(),
                h.getTieneEstacionamiento(),
                HotelMapper.toEntity(h.getHotel()).getId(),
                h.getFoto()
        );
    }
}
