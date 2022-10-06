package com.mdgz.dam.labdam2022.model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class Alojamiento {

    protected Integer id;
    protected String titulo;
    protected String descripcion;
    protected Integer capacidad;
    protected Double precioBase;
    protected String foto;

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
}
