package com.mdgz.dam.labdam2022.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Reserva {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="ID_RESERVA")
    private UUID id;

    @ColumnInfo(name="FECHA_INGRESO")
    private Instant fechaIngreso;
    @ColumnInfo(name="FECHA_EGRESO")
    private Instant fechaEgreso;
    @ColumnInfo(name="CANCELADA")
    private Boolean cancelada;
    @ColumnInfo(name="MONTO")
    private Double monto;

    public Reserva(){
        this.id=UUID.randomUUID();
    }

}
