package com.mdgz.dam.labdam2022.model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class Alojamiento implements Parcelable{

    protected Integer id;
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

    public Alojamiento(){
        super();
    }

    public Alojamiento(Integer id, String titulo, String descripcion, Integer capacidad,
                       Double precioBase, String foto) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
        this.foto = foto;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getFoto(){
        return foto;
    }

    public String getDescripcion() { return descripcion;}

    public int getCapacidad() { return capacidad;}

    public double getPrecioBase() { return precioBase;}

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(titulo);
        parcel.writeInt(capacidad);
        parcel.writeDouble(precioBase);
        parcel.writeString(foto);
    }
}
