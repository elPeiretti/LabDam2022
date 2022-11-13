package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.persistencia.room.dao.AlojamientoDAO;
import com.mdgz.dam.labdam2022.persistencia.room.entities.AlojamientoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.DepartamentoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HabitacionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlojamientoMapper {

    public static List<Alojamiento> fromEntities(List<AlojamientoEntity> ae) {
           return ae.stream().map(AlojamientoMapper::fromEntity).collect(Collectors.toList());
    }

    public static Alojamiento fromEntity(AlojamientoEntity a){
        //TODO
        // return a insanceof DepartamentoEntity ? DepartamentoMapper.fromEntity((DepartamentoEntity)a) : HabitacionMapper.fromEntity((HabitacionEntity) a);
        return null;
    }

    public static AlojamientoEntity toEntity(Alojamiento a){
        return new AlojamientoEntity(a.getTitulo(),a.getDescripcion(),a.getCapacidad(), a.getPrecioBase(), a.getFoto());
        }
    public static List<AlojamientoEntity> toEntites(List<Alojamiento> aloj){
    List<AlojamientoEntity> alojamientos = new ArrayList<AlojamientoEntity>();
    for(Alojamiento a : aloj ) {
        alojamientos.add(new AlojamientoEntity(a.getTitulo(), a.getDescripcion(), a.getCapacidad(),
                a.getPrecioBase(), a.getFoto()));
    }
    return alojamientos;
    }
}
