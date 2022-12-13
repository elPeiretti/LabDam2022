package com.mdgz.dam.labdam2022.persistencia.room.mapper;

import com.mdgz.dam.labdam2022.model.Reserva;
import com.mdgz.dam.labdam2022.persistencia.room.entities.ReservaEntity;
import java.util.List;
import java.util.stream.Collectors;

public class ReservaMapper {
    public static List<Reserva> fromEntities(List<ReservaEntity> reservas) {
        return reservas.stream().map(ReservaMapper::fromEntity).collect(Collectors.toList());
    }

    public static Reserva fromEntity(ReservaEntity r){
        return new Reserva(
                r.getId(),
                r.getFechaIngreso(),
                r.getFechaEgreso(),
                r.getCancelada(),
                r.getMonto(),
                r.getAlojamientoId(),
                r.getUsuarioID()
        );
    }

    public static ReservaEntity toEntity(Reserva r) {
        return new ReservaEntity(
                r.getId(),
                r.getFechaIngreso(),
                r.getFechaSalida(),
                r.getCancelada(),
                r.getMonto(),
                r.getAlojamientoId(),
                r.getUsuarioID()
        );
    }
}
