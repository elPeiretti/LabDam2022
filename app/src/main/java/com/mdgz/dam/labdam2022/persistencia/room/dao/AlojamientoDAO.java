package com.mdgz.dam.labdam2022.persistencia.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdgz.dam.labdam2022.persistencia.room.entities.AlojamientoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.CiudadEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.DepartamentoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HabitacionEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HotelEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.UbicacionEntity;

import java.util.List;

@Dao
public interface AlojamientoDAO {

    @Query("SELECT * FROM alojamientoentity")
    List<AlojamientoEntity> loadAllAlojamientos();
    @Query("SELECT * FROM departamentoentity")
    List<DepartamentoEntity> loadAllDepartamentos();
    @Query("SELECT * FROM habitacionentity")
    List<HabitacionEntity> loadAllHabitaciones();
    @Query("SELECT * FROM ubicacionentity")
    List<UbicacionEntity> loadAllUbicaciones();
    @Query("SELECT * FROM ciudadentity")
    List<CiudadEntity> loadAllCiudades();

    @Query("SELECT * FROM hotelentity")
    List<HotelEntity> loadAllHoteles();

    @Insert
    void insertAllDepartamentos(List<DepartamentoEntity> dptos);
    @Insert
    void insertAllHabitaciones(List<HabitacionEntity> habs);
    @Insert
    void insertAllAlojamientos(List<AlojamientoEntity> aloj);
    @Insert
    void insertAllUbicaciones(List<UbicacionEntity> ubicaciones);
    @Insert
    void insertAllHoteles(List<HotelEntity> hoteles);
    @Insert
    void insertAllCiudades(List<CiudadEntity> ciudades);

}