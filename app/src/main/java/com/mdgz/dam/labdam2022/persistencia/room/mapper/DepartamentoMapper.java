package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.persistencia.room.entities.DepartamentoEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DepartamentoMapper {

    public static Departamento fromEntity(DepartamentoEntity d) {
        return new Departamento(
                d.getId_departamento(),
                d.getTitulo(),
                d.getDescripcion(),
                d.getCapacidad(),
                d.getPrecioBase(),
                d.getTieneWifi(),
                d.getCostoLimpieza(),
                d.getCantidadHabitaciones(),
                UbicacionMapper.fromEntity(d.getUbicacion()),
                d.getFoto()
        );
    }

    public static List<DepartamentoEntity> toEntities(List<Departamento> departamentos) {
        return departamentos.stream().map(DepartamentoMapper::toEntity).collect(Collectors.toList());
    }

    public static DepartamentoEntity toEntity(Departamento d){
        return new DepartamentoEntity(
                d.getId_departamento(),
                d.getTitulo(),
                d.getDescripcion(),
                d.getCapacidad(),
                d.getPrecioBase(),
                d.getTieneWifi(),
                d.getCostoLimpieza(),
                d.getCantidadHabitaciones(),
                UbicacionMapper.toEntity(d.getUbicacion()),
                d.getFoto()
        );
    }
}
