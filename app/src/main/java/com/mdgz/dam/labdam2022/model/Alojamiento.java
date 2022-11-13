package com.mdgz.dam.labdam2022.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;


public abstract class Alojamiento implements Parcelable{

    protected UUID id;
    protected String titulo;
    protected String descripcion;
    protected Integer capacidad;
    protected Double precioBase;
    protected String foto;

    public Alojamiento(Parcel in) {
        titulo = in.readString();
        descripcion = in.readString();
        capacidad = in.readInt();
        precioBase = in.readDouble();
        foto = in.readString();
    }

    public abstract Ubicacion getUbicacion();
    public Double costoDia(){
        return precioBase;
    }

    public Alojamiento(){}

    public Alojamiento(UUID id, String titulo, String descripcion, Integer capacidad,
                       Double precioBase, String foto) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
        this.foto = foto;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(titulo);
        parcel.writeInt(capacidad);
        parcel.writeDouble(precioBase);
        parcel.writeString(foto);
    }

    public String getCaracteristicas(){
        return descripcion+".\nCapacidad: "+capacidad+" personas.\nPrecio base: $"+precioBase.toString()+".\n";
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
