package com.mdgz.dam.labdam2022.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public abstract class Alojamiento implements Parcelable{

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID_ALOJAMIENTO")
    protected Integer id;

    @ColumnInfo(name = "TITULO")
    protected String titulo;
    @ColumnInfo(name = "DESCRIPCION")
    protected String descripcion;
    @ColumnInfo(name = "CAPACIDAD")
    protected Integer capacidad;
    @ColumnInfo(name = "PRECIO")
    protected Double precioBase;
    @ColumnInfo(name = "FOTO")
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

    public String getCaracteristicas(){
        return descripcion+".\nCapacidad: "+capacidad+" personas.\nPrecio base: $"+precioBase.toString()+".\n";
    }
}
