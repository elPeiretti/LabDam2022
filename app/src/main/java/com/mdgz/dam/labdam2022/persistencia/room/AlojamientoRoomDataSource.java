package com.mdgz.dam.labdam2022.persistencia.room;

import android.content.Context;

import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.AlojamientoDataSource;
import com.mdgz.dam.labdam2022.persistencia.room.dao.AlojamientoDAO;

import java.util.ArrayList;
import java.util.List;

public class AlojamientoRoomDataSource implements AlojamientoDataSource {

    private AlojamientoDAO alojamientoDao;


    public AlojamientoRoomDataSource(Context ctx){
        MyDatabase bdd = MyDatabase.getInstance(ctx);
        alojamientoDao = bdd.alojamientoDAO();
    }

    @Override
    public void getAllAlojamientos(GetAllAlojamientosCallback callback) {
        List<Alojamiento> aloj = new ArrayList<Alojamiento>();
        aloj.addAll(alojamientoDao.loadAllDepartamentos());
        aloj.addAll(alojamientoDao.loadAllHabitaciones());
        callback.onResult(aloj);
    }

}
