package com.mdgz.dam.labdam2022.model;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Departamento extends Alojamiento{
    //@PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID_DEPARTAMENTO")
    protected Integer id_departamento;

    @ColumnInfo(name = "TIENE_WIFI")
    private Boolean tieneWifi;
    @ColumnInfo(name = "COSTO_LIMPIEZA")
    private Double costoLimpieza;
    @ColumnInfo(name = "CANTIDAD_HABITACIONES")
    private Integer cantidadHabitaciones;

    @Ignore
    private Ubicacion ubicacion;

    public static final Parcelable.Creator<Departamento> CREATOR =
            new Parcelable.Creator<Departamento>(){
                @Override
                public Departamento createFromParcel(Parcel parcel) {
                    return new Departamento(parcel);
                }

                @Override
                public Departamento[] newArray(int size) {
                    return new Departamento[size];
                }
            };

    protected Departamento(Parcel in){
        super(in);
        tieneWifi = in.readInt()==1;
        costoLimpieza=in.readDouble();
        cantidadHabitaciones=in.readInt();
        ubicacion=in.readParcelable(Ubicacion.class.getClassLoader());
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Departamento(){
        super();
    }

    public Departamento(Integer id, String titulo, String descripcion, Integer capacidad, Double precioBase, Boolean tieneWifi, Double costoLimpieza, Integer cantidadHabitaciones,Ubicacion ubicacion, String foto) {
        super(titulo, descripcion, capacidad, precioBase, foto);
        this.tieneWifi = tieneWifi;
        this.costoLimpieza = costoLimpieza;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.ubicacion = ubicacion;
        this.id_departamento = id;
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

    @Override
    public Ubicacion getUbicacion() {
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel,i);
        parcel.writeInt(tieneWifi?1:0);
        parcel.writeDouble(costoLimpieza);
        parcel.writeInt(cantidadHabitaciones);
        parcel.writeParcelable(ubicacion,i);
    }

    @Override
    public String getCaracteristicas(){
        return super.getCaracteristicas()+"Tipo: Departamento.\nWiFi: "+(tieneWifi?"Si":"No")+
                ".\nCantidad de habitaciones: "+cantidadHabitaciones.toString()+".\nCosto de limpieza: "+costoLimpieza.toString()+".\n"+
                "Ubicacion: "+ubicacion.toString()+".\n";
    }
}
