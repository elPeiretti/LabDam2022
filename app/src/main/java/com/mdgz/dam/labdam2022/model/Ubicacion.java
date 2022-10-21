package com.mdgz.dam.labdam2022.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity (foreignKeys = @ForeignKey(entity = Ciudad.class, parentColumns = "id", childColumns = "id"))
public class Ubicacion implements Parcelable {
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
    private Ciudad ciudad;

    public Ubicacion(){}

    public Ubicacion(double lat, double lng, String calle, String numero, Ciudad ciudad) {
        this.lat = lat;
        this.lng = lng;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    protected Ubicacion(Parcel in) {
        lat = in.readDouble();
        lng = in.readDouble();
        calle = in.readString();
        numero = in.readString();
        ciudad = in.readParcelable(Ciudad.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeString(calle);
        dest.writeString(numero);
        dest.writeParcelable(ciudad,flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ubicacion> CREATOR = new Creator<Ubicacion>() {
        @Override
        public Ubicacion createFromParcel(Parcel in) {
            return new Ubicacion(in);
        }

        @Override
        public Ubicacion[] newArray(int size) {
            return new Ubicacion[size];
        }
    };

    @Override
    public String toString(){
        return calle+" "+numero+", "+ciudad.toString();
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

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
