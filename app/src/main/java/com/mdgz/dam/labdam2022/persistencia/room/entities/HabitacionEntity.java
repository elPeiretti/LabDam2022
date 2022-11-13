package com.mdgz.dam.labdam2022.persistencia.room.entities;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.mdgz.dam.labdam2022.model.Hotel;

import java.util.UUID;

@Entity (foreignKeys = {
        @ForeignKey(entity = AlojamientoEntity.class, parentColumns = "ID_ALOJAMIENTO", childColumns = "ID_ALOJAMIENTO",
        onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),

        @ForeignKey(entity = HotelEntity.class, parentColumns = "ID_HOTEL", childColumns = "ID_HOTEL",
                onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
        })

public class HabitacionEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID_HABITACION")
    protected Integer id_habitacion;
    @ColumnInfo(name = "CAMAS_INDIVIDUALES")
    private int camasIndividuales;
    @ColumnInfo(name = "CAMAS_MATRIMONIALES")
    private int camasMatrimoniales;
    @ColumnInfo(name = "TIENE_ESTACIONAMIENTO")
    private Boolean tieneEstacionamiento;
    @ColumnInfo(name = "ID_ALOJAMIENTO")
    private UUID alojamientoId;
    @ColumnInfo(name = "ID_HOTEL")
    private Integer id_hotel;
    @Ignore
    HotelEntity hotelEntity;
    @Ignore
    AlojamientoEntity alojamientoEntity;

    public HabitacionEntity(){}

    @Ignore
    public HabitacionEntity(Integer id, String titulo, String descripcion, Integer capacidad, Double precioBase, int camasIndividuales, int camasMatrimoniales, Boolean tieneEstacionamiento, Integer hotelEntity, String foto) {
        this.camasIndividuales = camasIndividuales;
        this.camasMatrimoniales = camasMatrimoniales;
        this.tieneEstacionamiento = tieneEstacionamiento;
        this.id_hotel = hotelEntity;
        this.id_habitacion = id;
        this.alojamientoId = UUID.randomUUID();
    }

    @NonNull
    public Integer getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(@NonNull Integer id_habitacion) {
        this.id_habitacion = id_habitacion;
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

    public UUID getAlojamientoId() {
        return alojamientoId;
    }

    public void setAlojamientoId(UUID alojamientoId) {
        this.alojamientoId = alojamientoId;
    }

    public Integer getId_hotel() {
        return id_hotel;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    public AlojamientoEntity getAlojamientoEntity() {
        return alojamientoEntity;
    }

    public void setAlojamientoEntity(AlojamientoEntity alojamientoEntity) {
        this.alojamientoEntity = alojamientoEntity;
    }

    public void setId_hotel(Integer id_hotel) {
        this.id_hotel = id_hotel;
    }
}
