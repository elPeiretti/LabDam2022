package com.mdgz.dam.labdam2022.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;


public class Reserva {

    @NonNull
    private Integer id;
    private Instant fechaIngreso;
    private Instant fechaSalida;
    private Boolean cancelada;
    private Double monto;
    private UUID alojamientoId;
    private UUID usuarioId;

    public Reserva(){}

    public Reserva(Integer id, Instant fechaIngreso, Instant fechaSalida, Boolean cancelada, Double monto, UUID alojamientoId, UUID usuarioID){
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.cancelada = cancelada;
        this.monto = monto;
        this.alojamientoId = alojamientoId;
        this.usuarioId = usuarioID;
    }
    public Reserva(UUID alojId, UUID userId, Instant fechaIngreso, Instant fechaSalida){
        this.alojamientoId = alojId;
        this.usuarioId = userId;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
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

    public Instant getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Instant fechaEgreso) {
        this.fechaSalida = fechaEgreso;
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
        return usuarioId;
    }

    public void setUsuarioID(UUID usuarioID) {
        this.usuarioId = usuarioID;
    }
}
