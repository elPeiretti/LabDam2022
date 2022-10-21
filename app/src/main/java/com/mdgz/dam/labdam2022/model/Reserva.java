package com.mdgz.dam.labdam2022.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.Instant;

@Entity
public class Reserva {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name="ID_RESERVA")
    private Integer id;
    @ColumnInfo(name="FECHA_INGRESO")
    private Instant fechaIngreso;
    @ColumnInfo(name="FECHA_EGRESO")
    private Instant fechaEgreso;
    @ColumnInfo(name="CANCELADA")
    private Boolean cancelada;
    @ColumnInfo(name="MONTO")
    private Double monto;
    @ColumnInfo(name="ID_ALOJAMIENTO")
    private Integer Alojamiento;

    public Reserva(){}

}
