package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.persistencia.room.entities.AlojamientoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.CiudadEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.DepartamentoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HabitacionEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.UbicacionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DepartamentoMapper {

    public static Departamento fromEntity(DepartamentoEntity d, AlojamientoEntity a, UbicacionEntity u, CiudadEntity c) {
        return new Departamento(
                d.getAlojamientoId(),
                d.getId_departamento(),
                a.getTitulo(),
                a.getDescripcion(),
                a.getCapacidad(),
                a.getPrecioBase(),
                d.getTieneWifi(),
                d.getCostoLimpieza(),
                d.getCantidadHabitaciones(),
                UbicacionMapper.fromEntity(u,c),
                a.getFoto()
        );
    }

    public static List<DepartamentoEntity> toEntities(List<Departamento> departamentos) {
        return departamentos.stream().map(DepartamentoMapper::toEntity).collect(Collectors.toList());
    }

    public static List<Departamento> fromEntities(List<DepartamentoEntity> dptos){
        List<Departamento> departamentos = new ArrayList<Departamento>();
        for(DepartamentoEntity h: dptos){
            departamentos.add(DepartamentoMapper.fromEntity(h, h.getAlojamientoEntity(), h.getUbicacionEntity(), h.getUbicacionEntity().getCiudadEntity()));
        }
        return departamentos;
    }

    public static DepartamentoEntity toEntity(Departamento d){
        return new DepartamentoEntity(
                d.getId(),
                d.getId_departamento(),
                d.getTitulo(),
                d.getDescripcion(),
                d.getCapacidad(),
                d.getPrecioBase(),
                d.getTieneWifi(),
                d.getCostoLimpieza(),
                d.getCantidadHabitaciones(),
                UbicacionMapper.toEntity(d.getUbicacion()).getId(),
                d.getFoto()
        );
    }
}
