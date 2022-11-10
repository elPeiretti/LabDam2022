package com.mdgz.dam.labdam2022.persistencia.room.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity()
public class HotelEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID_HOTEL")
    Integer id;
    @ColumnInfo(name = "NOMBRE")
    String nombre;
    @ColumnInfo(name = "CATEGORIA")
    Integer categoria;

    @Ignore
    UbicacionEntity ubicacionEntity;

    public HotelEntity(){
        super();
    }

    public HotelEntity(Integer id, String nombre, Integer categoria, UbicacionEntity ubicacionEntity) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.ubicacionEntity = ubicacionEntity;
    }

    @Override
    public String toString(){
        return "Hotel "+nombre+", "+ ubicacionEntity.toString();
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

    public UbicacionEntity getUbicacion() {
        return ubicacionEntity;
    }

    public void setUbicacion(UbicacionEntity ubicacionEntity) {
        this.ubicacionEntity = ubicacionEntity;
    }
}
