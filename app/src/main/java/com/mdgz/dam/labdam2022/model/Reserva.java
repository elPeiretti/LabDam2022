package com.mdgz.dam.labdam2022.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.Instant;
import java.util.UUID;


public class Reserva {

    @NonNull
    private Integer id;
    private Instant fechaIngreso;
    private Instant fechaEgreso;
    private Boolean cancelada;
    private Double monto;
    private UUID alojamientoId;
    private UUID usuarioID;

    public Reserva(){}

    public Reserva(Integer id, Instant fechaIngreso, Instant fechaEgreso, Boolean cancelada, Double monto, UUID alojamientoId, UUID usuarioID){
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.cancelada = cancelada;
        this.monto = monto;
        this.alojamientoId = alojamientoId;
        this.usuarioID = usuarioID;
    }

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

    public UUID getAlojamientoId() {
        return alojamientoId;
    }

    public void setAlojamientoId(UUID alojamiento) {
        alojamiento = alojamientoId;
    }

    public UUID getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(UUID usuarioID) {
        this.usuarioID = usuarioID;
    }
}
