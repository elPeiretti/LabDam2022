package com.mdgz.dam.labdam2022.persistencia.room.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity()
public class CiudadEntity {
    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name="ID_CIUDAD")
    Integer id;
    @ColumnInfo(name="NOMBRE")
    String nombre;
    @ColumnInfo(name="ABREVIATURA")
    String abreviatura;

    public CiudadEntity(){}

    @Ignore
    public CiudadEntity(String nombre, String abreviatura, Integer id) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.id = id;
    }


    @NonNull
    @Override
    public String toString(){
        return nombre;
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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

}
