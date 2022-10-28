package com.mdgz.dam.labdam2022.persistencia.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Habitacion;

import java.util.List;

@Dao
public interface AlojamientoDAO {


    //List<Alojamiento> loadAllAlojamientos();
    @Query("SELECT * FROM departamento")
    List<Departamento> loadAllDepartamentos();
    @Query("SELECT * FROM habitacion")
    List<Habitacion> loadAllHabitaciones();

    @Insert
    void insertAllDepartamentos(List<Departamento> dptos);
    @Insert
    void insertAllHabitaciones(List<Habitacion> habs);

}