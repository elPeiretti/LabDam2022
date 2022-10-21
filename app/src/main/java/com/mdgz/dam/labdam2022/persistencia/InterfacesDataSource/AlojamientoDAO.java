package com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource;

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

    //borrar?
    @Insert
    void insertDepartamento(Departamento depto);
}
