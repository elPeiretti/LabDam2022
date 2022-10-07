package com.mdgz.dam.labdam2022.model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Habitacion  extends Alojamiento {

    private int camasIndividuales;
    private int camasMatrimoniales;
    private Boolean tieneEstacionamiento;
    private Hotel hotel;

    public Habitacion() {
        super();
    }
    public Habitacion(Parcel p){
        super(p);
        camasIndividuales=p.readInt();
        camasMatrimoniales=p.readInt();
        tieneEstacionamiento=p.readInt()==1;
        hotel=p.readParcelable(Hotel.class.getClassLoader());
    }

    public static final Parcelable.Creator<Habitacion> CREATOR =
            new Parcelable.Creator<Habitacion>(){

                @Override
                public Habitacion createFromParcel(Parcel parcel) {
                    return new Habitacion(parcel);
                }

                @Override
                public Habitacion[] newArray(int size) {
                    return new Habitacion[size];
                }
            };

    public Habitacion(Integer id, String titulo, String descripcion, Integer capacidad, Double precioBase, int camasIndividuales, int camasMatrimoniales, Boolean tieneEstacionamiento, Hotel hotel, String foto) {
        super(id, titulo, descripcion, capacidad, precioBase,foto);
        this.camasIndividuales = camasIndividuales;
        this.camasMatrimoniales = camasMatrimoniales;
        this.tieneEstacionamiento = tieneEstacionamiento;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCamasIndividuales() {
        return camasIndividuales;
    }

    public void setCamasIndividuales(int camasIndividuales) {
        this.camasIndividuales = camasIndividuales;
    }

    public int getCamasMatrimoniales() {
        return camasMatrimoniales;
    }

    public void setCamasMatrimoniales(int camasMatrimoniales) {
        this.camasMatrimoniales = camasMatrimoniales;
    }

    public Boolean getTieneEstacionamiento() {
        return tieneEstacionamiento;
    }

    public void setTieneEstacionamiento(Boolean tieneEstacionamiento) {
        this.tieneEstacionamiento = tieneEstacionamiento;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public Ubicacion getUbicacion() {
        return hotel.getUbicacion();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags){
        super.writeToParcel(parcel,flags);
        parcel.writeInt(camasIndividuales);
        parcel.writeInt(camasMatrimoniales);
        parcel.writeInt(tieneEstacionamiento?1:0);
        parcel.writeParcelable(hotel,flags);
    }

    @Override
    public String getCaracteristicas(){
        return super.getCaracteristicas()+" Tipo: Habitacion"+". Cantidad de camas individuales: "+String.valueOf(camasIndividuales)+
                ". Cantidad de camas matrimoniales: "+String.valueOf(camasMatrimoniales)+". Tiene estacionamiento: "+(tieneEstacionamiento?"Si":"No")+
                ". Ubicacion: "+hotel.toString()+".";
    }

}
