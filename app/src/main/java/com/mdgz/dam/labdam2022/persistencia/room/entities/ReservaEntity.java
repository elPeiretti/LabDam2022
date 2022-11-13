package com.mdgz.dam.labdam2022.persistencia.room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.Instant;
import java.util.UUID;

@Entity(foreignKeys = @ForeignKey(entity = AlojamientoEntity.class, parentColumns = "ID_ALOJAMIENTO", childColumns = "ID_ALOJAMIENTO"))
public class ReservaEntity {

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
    private UUID alojamientoId;
    @ColumnInfo(name="ID_USUARIO")
    private UUID usuarioID;

    public ReservaEntity(){}
    @Ignore
    public ReservaEntity(Integer id, Instant fechaIngreso, Instant fechaEgreso, Boolean cancelada, Double monto, UUID alojamientoId, UUID usuarioID){
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
        alojamientoId = alojamiento;
    }

    public UUID getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(UUID usuarioID) {
        this.usuarioID = usuarioID;
    }
}
