package com.mdgz.dam.labdam2022.persistencia.room.entities;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity()
public class DepartamentoEntity extends AlojamientoEntity {
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
    private UbicacionEntity ubicacionEntity;

    public void setUbicacion(UbicacionEntity ubicacionEntity) {
        this.ubicacionEntity = ubicacionEntity;
    }

    public DepartamentoEntity(){
        super();
    }

    public DepartamentoEntity(Integer id, String titulo, String descripcion, Integer capacidad, Double precioBase, Boolean tieneWifi, Double costoLimpieza, Integer cantidadHabitaciones, UbicacionEntity ubicacionEntity, String foto) {
        super(titulo, descripcion, capacidad, precioBase, foto);
        this.tieneWifi = tieneWifi;
        this.costoLimpieza = costoLimpieza;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.ubicacionEntity = ubicacionEntity;
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
    public UbicacionEntity getUbicacion() {
        return null;
    }

    @Override
    public String getCaracteristicas(){
        return super.getCaracteristicas()+"Tipo: Departamento.\nWiFi: "+(tieneWifi?"Si":"No")+
                ".\nCantidad de habitaciones: "+cantidadHabitaciones.toString()+".\nCosto de limpieza: "+costoLimpieza.toString()+".\n"+
                "Ubicacion: "+ ubicacionEntity.toString()+".\n";
    }
}
