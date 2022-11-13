package com.mdgz.dam.labdam2022.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class Habitacion  extends Alojamiento {

    protected Integer id_habitacion;
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

    public Habitacion(Alojamiento a, Integer id, int camasIndividuales, int camasMatrimoniales, Boolean tieneEstacionamiento, Hotel hotel){
        this.id = a.getId();
        this.titulo = a.getTitulo();
        this.descripcion= a.getDescripcion();
        this.precioBase = a.getPrecioBase();
        this.capacidad= a.getCapacidad();
        this.foto = a.getFoto();
        this.camasIndividuales = camasIndividuales;
        this.camasMatrimoniales = camasMatrimoniales;
        this.tieneEstacionamiento = tieneEstacionamiento;
        this.hotel = hotel;
        this.id_habitacion = id;
    }

    public Habitacion(UUID uuid, Integer id, String titulo, String descripcion, Integer capacidad, Double precioBase, int camasIndividuales, int camasMatrimoniales, Boolean tieneEstacionamiento, Hotel hotel, String foto) {
        super(uuid, titulo, descripcion, capacidad, precioBase,foto);
        this.camasIndividuales = camasIndividuales;
        this.camasMatrimoniales = camasMatrimoniales;
        this.tieneEstacionamiento = tieneEstacionamiento;
        this.hotel = hotel;
        this.id_habitacion = id;
    }

    public Integer getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Integer id) {
        this.id_habitacion = id;
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
       return super.getCaracteristicas()+"Tipo: Habitacion"+".\nCantidad de camas individuales: "+String.valueOf(camasIndividuales)+
                ".\nCantidad de camas matrimoniales: "+String.valueOf(camasMatrimoniales)+".\nTiene estacionamiento: "+(tieneEstacionamiento?"Si":"No")+
                ".\nUbicacion: "+hotel.toString()+".\n";
    }

}
