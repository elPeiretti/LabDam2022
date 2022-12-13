package com.mdgz.dam.labdam2022.persistencia.retrofit.mapper;



import com.mdgz.dam.labdam2022.model.Reserva;
import com.mdgz.dam.labdam2022.persistencia.retrofit.entity.ReservaRF;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReservaMapper {

    public static List<Reserva> fromEntities(List<ReservaRF> entities){
        return entities.stream().map(ReservaMapper::fromEntity).collect(Collectors.toList());
    }

    public static ReservaRF toEntity(Reserva res){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
                .withZone(ZoneId.from(ZoneOffset.UTC));
        return new ReservaRF(
                res.getAlojamientoId().toString(),
                res.getUsuarioID().toString(),
                formatter.format(res.getFechaIngreso()),
                formatter.format(res.getFechaSalida())

        );
    }

    public static Reserva fromEntity(ReservaRF res){
        return new Reserva(
                UUID.fromString(res.getAlojamientoId()),
                UUID.fromString(res.getUsuarioId()),
                Instant.parse(res.getFechaIngreso()),
                Instant.parse(res.getFechaSalida())
        );
    }
}
