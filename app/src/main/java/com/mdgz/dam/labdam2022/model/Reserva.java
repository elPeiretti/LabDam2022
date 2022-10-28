package com.mdgz.dam.labdam2022.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.Instant;
import java.util.UUID;

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
    private UUID Alojamiento;
    @ColumnInfo(name="ID_USUARIO")
    private UUID usuarioID;

    public Reserva(){}

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public Instant getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Instant fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Instant getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Instant fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Boolean getCancelada() {
        return cancelada;
    }

    public void setCancelada(Boolean cancelada) {
        this.cancelada = cancelada;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public UUID getAlojamiento() {
        return Alojamiento;
    }

    public void setAlojamiento(UUID alojamiento) {
        Alojamiento = alojamiento;
    }

    public UUID getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(UUID usuarioID) {
        this.usuarioID = usuarioID;
    }
}
