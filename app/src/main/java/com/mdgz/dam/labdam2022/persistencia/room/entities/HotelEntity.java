package com.mdgz.dam.labdam2022.persistencia.room.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.mdgz.dam.labdam2022.model.Ubicacion;

@Entity(foreignKeys = @ForeignKey(entity = UbicacionEntity.class, parentColumns = "ID_UBICACION", childColumns = "ID_UBICACION"))

public class HotelEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID_HOTEL")
    Integer id;
    @ColumnInfo(name = "NOMBRE")
    String nombre;
    @ColumnInfo(name = "CATEGORIA")
    Integer categoria;

    @ColumnInfo(name = "ID_UBICACION")
    Integer id_ubicacion;

    @Ignore
    UbicacionEntity ubicacionEntity;

    public HotelEntity(){}

    @Ignore
    public HotelEntity(String nombre, Integer categoria, Integer ubicacionEntity) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.id_ubicacion = ubicacionEntity;
    }

    @Override
    public String toString(){
        return "Hotel "+nombre+", "+ id_ubicacion.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getIdUbicacion() {
        return id_ubicacion;
    }

    public Integer getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(Integer id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public UbicacionEntity getUbicacionEntity() {
        return ubicacionEntity;
    }

    public void setUbicacionEntity(UbicacionEntity ubicacionEntity) {
        this.ubicacionEntity = ubicacionEntity;
    }

}
