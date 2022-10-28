package com.mdgz.dam.labdam2022.persistencia.room;

import android.content.Context;

import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.persistencia.room.dao.AlojamientoDAO;

import java.util.List;

public class AlojamientoRoomDataSource {

    private static AlojamientoRoomDataSource instance = null;
    private AlojamientoDAO alojamientoDao;


    private AlojamientoRoomDataSource(Context ctx){
        MyDatabase bdd = MyDatabase.getInstance(ctx);
        alojamientoDao = bdd.alojamientoDAO();
    }

    public static AlojamientoRoomDataSource getInstance(Context ctx){
        return instance == null ? (instance = new AlojamientoRoomDataSource(ctx)) : instance;
    }

    public List<Departamento> getAllDepartamentos() {
        return alojamientoDao.loadAllDepartamentos();
    }

    public List<Habitacion> getAllHabitaciones() {
        return alojamientoDao.loadAllHabitaciones();
    }
}
