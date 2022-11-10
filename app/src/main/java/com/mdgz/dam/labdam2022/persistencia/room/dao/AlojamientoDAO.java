package com.mdgz.dam.labdam2022.persistencia.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.persistencia.room.entities.DepartamentoEntity;
import com.mdgz.dam.labdam2022.persistencia.room.entities.HabitacionEntity;

import java.util.List;

@Dao
public interface AlojamientoDAO {


    //List<Alojamiento> loadAllAlojamientos();
    @Query("SELECT * FROM departamentoentity")
    List<DepartamentoEntity> loadAllDepartamentos();
    @Query("SELECT * FROM habitacionentity")
    List<HabitacionEntity> loadAllHabitaciones();

    @Insert
    void insertAllDepartamentos(List<DepartamentoEntity> dptos);
    @Insert
    void insertAllHabitaciones(List<HabitacionEntity> habs);

}