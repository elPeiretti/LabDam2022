package com.mdgz.dam.labdam2022.persistencia.room.entities;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.mdgz.dam.labdam2022.model.Ubicacion;

import java.util.UUID;

@Entity (foreignKeys = {
        @ForeignKey(entity = AlojamientoEntity.class, parentColumns = "ID_ALOJAMIENTO", childColumns = "ID_ALOJAMIENTO",
                onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = UbicacionEntity.class, parentColumns = "ID_UBICACION", childColumns = "ID_UBICACION",
                onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)})

public class DepartamentoEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID_DEPARTAMENTO")
    protected Integer id_departamento;
    @ColumnInfo(name = "TIENE_WIFI")
    private Boolean tieneWifi;
    @ColumnInfo(name = "COSTO_LIMPIEZA")
    private Double costoLimpieza;
    @ColumnInfo(name = "CANTIDAD_HABITACIONES")
    private Integer cantidadHabitaciones;
    @ColumnInfo(name = "ID_ALOJAMIENTO")
    private UUID alojamientoId;
    @ColumnInfo(name = "ID_UBICACION")
    private Integer id_ubicacion;
    @Ignore
    private AlojamientoEntity alojamientoEntity;
    @Ignore
    private UbicacionEntity ubicacionEntity;

    public void setUbicacion(Integer ubicacionEntity) {
        this.id_ubicacion = ubicacionEntity;
    }

    public DepartamentoEntity(){}

    @Ignore
    public DepartamentoEntity(Integer id, String titulo, String descripcion, Integer capacidad, Double precioBase, Boolean tieneWifi, Double costoLimpieza, Integer cantidadHabitaciones, Integer ubicacionEntity, String foto) {
        this.tieneWifi = tieneWifi;
        this.costoLimpieza = costoLimpieza;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.id_ubicacion = ubicacionEntity;
        this.id_departamento = id;
        this.alojamientoId = UUID.randomUUID();
    }

    @NonNull
    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(@NonNull Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Boolean getTieneWifi() {
        return tieneWifi;
    }

    public void setTieneWifi(Boolean tieneWifi) {
        this.tieneWifi = tieneWifi;
    }

    public Double getCostoLimpieza() {
        return costoLimpieza;
    }

    public void setCostoLimpieza(Double costoLimpieza) {
        this.costoLimpieza = costoLimpieza;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public UUID getAlojamientoId() {
        return alojamientoId;
    }

    public void setAlojamientoId(UUID alojamientoId) {
        this.alojamientoId = alojamientoId;
    }

    public Integer getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(Integer id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public AlojamientoEntity getAlojamientoEntity() {
        return alojamientoEntity;
    }

    public void setAlojamientoEntity(AlojamientoEntity alojamientoEntity) {
        this.alojamientoEntity = alojamientoEntity;
    }

    public UbicacionEntity getUbicacionEntity() {
        return ubicacionEntity;
    }

    public void setUbicacionEntity(UbicacionEntity ubicacionEntity) {
        this.ubicacionEntity = ubicacionEntity;
    }
}
