package com.mdgz.dam.labdam2022.persistencia.room.entities;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity()
public class HabitacionEntity extends AlojamientoEntity {
    //@PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID_HABITACION")
    protected Integer id_habitacion;
    @ColumnInfo(name = "CAMAS_INDIVIDUALES")
    private int camasIndividuales;
    @ColumnInfo(name = "CAMAS_MATRIMONIALES")
    private int camasMatrimoniales;
    @ColumnInfo(name = "TIENE_ESTACIONAMIENTO")
    private Boolean tieneEstacionamiento;

    @Ignore
    private HotelEntity hotelEntity;

    public HabitacionEntity() {
        super();
    }

    public HabitacionEntity(Integer id, String titulo, String descripcion, Integer capacidad, Double precioBase, int camasIndividuales, int camasMatrimoniales, Boolean tieneEstacionamiento, HotelEntity hotelEntity, String foto) {
        super(titulo, descripcion, capacidad, precioBase,foto);
        this.camasIndividuales = camasIndividuales;
        this.camasMatrimoniales = camasMatrimoniales;
        this.tieneEstacionamiento = tieneEstacionamiento;
        this.hotelEntity = hotelEntity;
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

    public HotelEntity getHotel() {
        return hotelEntity;
    }

    public void setHotel(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    @Override
    public UbicacionEntity getUbicacion() {
        return hotelEntity.getUbicacion();
    }

    @Override
    public String getCaracteristicas(){
       return super.getCaracteristicas()+"Tipo: Habitacion"+".\nCantidad de camas individuales: "+String.valueOf(camasIndividuales)+
                ".\nCantidad de camas matrimoniales: "+String.valueOf(camasMatrimoniales)+".\nTiene estacionamiento: "+(tieneEstacionamiento?"Si":"No")+
                ".\nUbicacion: "+ hotelEntity.toString()+".\n";
    }

}
