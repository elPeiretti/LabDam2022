package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HabitacionEntity;

import java.util.List;
import java.util.stream.Collectors;

public class HabitacionMapper {

    public static Habitacion fromEntity(HabitacionEntity h) {
        return new Habitacion(
                h.getId_habitacion(),
                h.getTitulo(),
                h.getDescripcion(),
                h.getCapacidad(),
                h.getPrecioBase(),
                h.getCamasIndividuales(),
                h.getCamasMatrimoniales(),
                h.getTieneEstacionamiento(),
                HotelMapper.fromEntity(h.getHotel()),
                h.getFoto()
        );
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
                HotelMapper.toEntity(h.getHotel()),
                h.getFoto()
        );
    }
}
