package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.persistencia.room.entities.AlojamientoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.DepartamentoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HabitacionEntity;
import java.util.List;
import java.util.stream.Collectors;

public class AlojamientoMapper {

    public static List<Alojamiento> fromEntities(List<AlojamientoEntity> ae) {
           return ae.stream().map(AlojamientoMapper::fromEntity).collect(Collectors.toList());
    }

    public static Alojamiento fromEntity(AlojamientoEntity a){
        //TODO
        return a instanceof DepartamentoEntity ? DepartamentoMapper.fromEntity((DepartamentoEntity)a) : HabitacionMapper.fromEntity((HabitacionEntity) a);
    }

}
