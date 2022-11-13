package com.mdgz.dam.labdam2022.persistencia.room.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (foreignKeys = @ForeignKey(entity = CiudadEntity.class, parentColumns = "ID_CIUDAD", childColumns = "ID_UBICACION"))
public class UbicacionEntity {
    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name="ID_UBICACION")
    private Integer id;
    @ColumnInfo(name="LAT")
    private double lat;
    @ColumnInfo(name="LNG")
    private double lng;
    @ColumnInfo(name="CALLE")
    private String calle;
    @ColumnInfo(name="NUMERO")
    private String numero;
    @ColumnInfo(name="ID_CIUDAD")
    private Integer idCiudad;

    @Ignore
    private CiudadEntity ciudadEntity;

    public UbicacionEntity(){}
    @Ignore
    public UbicacionEntity(Integer id, double lat, double lng, String calle, String numero, CiudadEntity ciudadEntity) {
        this.lat = lat;
        this.lng = lng;
        this.calle = calle;
        this.numero = numero;
        this.ciudadEntity = ciudadEntity;
        this.id = id;
    }

    @Override
    public String toString(){
        return calle+" "+numero+", "+ ciudadEntity.toString();
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public CiudadEntity getCiudad() {
        return ciudadEntity;
    }

    public void setCiudad(CiudadEntity ciudadEntity) {
        this.ciudadEntity = ciudadEntity;
    }
}
